package es.basallo.secretscapescodetest

import grails.test.spock.IntegrationSpec
import spock.lang.Shared

class TransactionServiceIntegrationSpec extends IntegrationSpec {

    def transactionService

    @Shared from
    @Shared to
    @Shared transaction

    def setup() {
        from = new Account(name: 'from', email: 'from@b.com')
        to = new Account(name: 'to', email: 'to@b.com')
        transaction = new Transaction(from: from, to: to, amount: 10.0)
    }

    def 'if transaction validates, tranfer is issued, email is sent and returns true'() {

        when:
        def result = transactionService.execute(transaction)

        then:
        transaction.fromAccountBalance == 190.0
        transaction.toAccountBalance == 210.0
        transaction.from.id
        transaction.to.id
        transaction.id
        result
    }

    def 'if transaction does not validate, due to from and to being equal, nothing is done and returns false'() {

        expect:
        !transactionService.execute(new Transaction(from: from, to: from, amount: 10.0))
    }

    def 'if transaction does not validate, due to excessive amount, nothing is done and returns false'() {

        expect:
        !transactionService.execute(new Transaction(from: from, to: to, amount: 201.0))
    }
}
