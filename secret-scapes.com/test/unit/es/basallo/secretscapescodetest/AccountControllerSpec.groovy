package es.basallo.secretscapescodetest

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

@TestFor(AccountController)
@Mock([Account, Transaction])
class AccountControllerSpec extends Specification {

    @Shared def transaction
    @Shared def firstAccount
    @Shared def secondAccount
    @Shared def thirdAccount

    def setup() {
        firstAccount = new Account(name: 'first', email: 'a@b.com').save()
        secondAccount = new Account(name: 'second', email: 'b@b.com').save()
        thirdAccount = new Account(name: 'third', email: 'c@b.com').save()
        transaction = new Transaction(from: firstAccount, to: thirdAccount, amount: 1.0).save()
        firstAccount.addToTransactions(transaction).save()
    }

    def 'returns all accounts; balance and transactions of the first'() {

        when:
        def result = controller.transactions()

        then:
        result.accounts == [firstAccount, secondAccount, thirdAccount]
        result.balance == firstAccount.balance
        result.incomingAndOutgoingTransactions[0] == transaction
    }

    def 'on empty account, balance is null and transactions empty list'() {

        setup:
        Account.list()*.delete()

        expect:
        controller.transactions() == [accounts:[], balance:null, incomingAndOutgoingTransactions:[]]
    }

    def 'when a account is selected, balance and transactions list must match those of the selection'() {

        given:
        controller.params.from = '2'

        when:
        def result = controller.transactions()

        then:
        result.balance == secondAccount.balance
        result.transactions == secondAccount.transactions
    }

    def 'incoming transactions are included too'() {

        given:
        def incomingTransaction = new Transaction(from: secondAccount, to: firstAccount, amount: 1.0).save()
        firstAccount.save()
        secondAccount.save()

        when:
        def result = controller.transactions()

        then:
        result.incomingAndOutgoingTransactions.size() == 2
        result.incomingAndOutgoingTransactions[0] == transaction
        result.incomingAndOutgoingTransactions[1] == incomingTransaction
    }

    def 'returns all accounts and renders payment form'() {

        expect:
        controller.pay().accounts == [firstAccount, secondAccount, thirdAccount]
    }

    def 'if transaction created from params validates, saves new object and redirects to transactions list'() {

        given:
        controller.params.from = new Account(name: 'first', email: 'a1@b.com').save()
        controller.params.to = new Account(name: 'second', email: 'a2@b.com').save()
        controller.params.amount = 1.0
        controller.transactionService = Mock(TransactionService)

        1 * controller.transactionService.execute(_) >> true

        when:
        controller.payExecution()

        then:
        response.redirectedUrl.endsWith '/transactions'
        flash.message == 'accountController.flash.message.success'
    }

    def 'if does not validates, renders payment form including accounts list and invalid transaction as model'() {

        when:
        controller.payExecution()

        then:
        view.endsWith '/pay'
        model.accounts == [firstAccount, secondAccount, thirdAccount]
        model.transaction.from == null
        model.transaction.to == null
        model.transaction.amount == null
        flash.message == 'accountController.flash.message.failure'
    }
}
