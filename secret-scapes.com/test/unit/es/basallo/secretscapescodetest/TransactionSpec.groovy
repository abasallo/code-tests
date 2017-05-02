package es.basallo.secretscapescodetest

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Transaction)
@Mock([Transaction, Account])
class TransactionSpec extends Specification {

    @Shared firstAccount = Mock(Account)
    @Shared secondAccount = Mock(Account)

    @Unroll
    def 'no property can be null'() {

        setup:
        def validTransaction = new Transaction(from: Mock(Account), to: Mock(Account), amount: 0.0)
        validTransaction."${property}" = contents

        expect:
        validTransaction.validate() == validates

        where:
        property    | contents  | validates
        'from'      | null      | false
        'to'        | null      | false
        'amount'    | null      | false
    }

    @Unroll
    def 'amount must be higher than zero'() {

        setup:
        def validTransaction = new Transaction(from: Mock(Account), to: Mock(Account), amount: amount)

        expect:
        validTransaction.validate() == validates

        where:
        amount  | validates
        null    | false
        -2.5    | false
        -1.0    | false
        0.0     | false
        0.01    | true
        2.5     | true
    }

    @Unroll
    def 'amount must be below transaction balance'() {

        setup:
        def from = Mock(Account)
        def validTransaction = new Transaction(from: from, to: Mock(Account), amount: amount)

        1 * from.balance >> 10.0

        expect:
        validTransaction.isAmountBelowBalance() == validates

        where:
        amount  | validates
        9.1     | true
        10.0    | true
        10.1    | false
    }

    def 'from and to must be different for a transaction to be valid'() {

        setup:
        def transaction = new Transaction(amount: 1.0)
        transaction.from = from
        transaction.to = to

        expect:
        transaction.isFromDifferentFromTo() == areDifferent

        where:
        from            | to            | areDifferent
        firstAccount    | secondAccount | true
        firstAccount    | firstAccount  | false
    }

    def 'transients give access to account info to avoid breaking law of Demeter'() {

        setup:
        def from = new Account(name: 'fromName', balance: 1.0, email: 'from@b.com')
        def to = new Account(name: 'toName', balance: 2.0, email: 'to@b.com')
        def transaction = new Transaction(from: from, to: to, amount: 3.0)

        expect:
        transaction.fromAccountName == from.name
        transaction.fromAccountEmail == from.email
        transaction.fromAccountBalance == from.balance
        transaction.toAccountName == to.name
        transaction.toAccountEmail == to.email
        transaction.toAccountBalance == to.balance

        and:

        when:
        transaction.fromAccountBalance = 10.0
        transaction.toAccountBalance = 20.0

        then:
        transaction.fromAccountBalance == 10.0
        transaction.toAccountBalance == 20.0
    }
}
