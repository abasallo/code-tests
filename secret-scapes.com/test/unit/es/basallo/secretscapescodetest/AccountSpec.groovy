package es.basallo.secretscapescodetest

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Account)
@Mock([Transaction, Account])
class AccountSpec extends Specification {

    @Shared validAccount = new Account(name: 'name', email: 'a@b.com')

    @Unroll
    def 'text properties cannot be blank'() {

        setup:
        validAccount."${property}" = text

        expect:
        validAccount.validate() == validates

        where:
        property            | text        | validates
        'name'              | ''          | false
        'name'              | 'name'      | true
        'email'             | ''          | false
        'email'             | 'a@b.com'   | true
    }

    @Unroll
    def 'no property can be null'() {

        setup:
        validAccount."${property}" = contents

        expect:
        validAccount.validate() == validates

        where:
        property    | contents  | validates
        'name'      | null      | false
        'balance'   | null      | false
        'email'     | null      | false
    }

    @Unroll
    def 'email must be valid'() {

        setup:
        def account = new Account(name: 'name', email: email)

        expect:
        account.validate() == validates

        where:
        email           | validates
        'a'             | false
        'a@'            | false
        'a@b.c'         | false
        'a@b.invalid'   | false
        'a@b.com'       | true
    }

    @Unroll
    def 'balance must be zero or higher'() {

        setup:
        def account = new Account(name: 'name', balance: balance, email: 'a@b.com')

        expect:
        account.validate() == validates

        where:
        balance | validates
        null    | false
        -2.5    | false
        -1.0    | false
        0.0     | true
        1.0     | true
        2.5     | true
    }

    def 'if no balance is specified, is set to default value'() {

        expect:
        new Account(name: 'name', email: 'a@b.com').balance == 200
    }

    def 'returns incoming and outgoing transactions from this account'() {

        given:
        def account = new Account(name: 'name', email: 'a@b.com').save()
        def otherAccount = new Account(name: 'otherName', email: 'b@b.com').save()
        def incoming = new Transaction(from: otherAccount, to: account, amount: 1.0).save()
        def outgoing = new Transaction(from: account, to: otherAccount, amount: 2.0).save()

        when:
        def result = account.incomingAndOutgoingTransactions

        then:
        result.size() == 2
        result[0] == incoming
        result[1] == outgoing
    }
}
