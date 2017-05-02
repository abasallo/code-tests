package es.basallo.secretscapescodetest

import grails.test.spock.IntegrationSpec
import spock.lang.Shared

class TransactionServiceGreenmailIntegrationSpec extends IntegrationSpec {

    def greenMail
    def transactionService

    @Shared from
    @Shared to
    @Shared transaction

    def setupSpec() {
        from = new Account(name: 'from', email: 'from@b.com')
        to = new Account(name: 'to', email: 'to@b.com')
        transaction = new Transaction(from: from, to: to, amount: 10.0)
    }

    def 'sends confirmation emails to sender'() {

        when:
        transactionService.sendFromConfirmationEmails(transaction)

        then:
        greenMail.receivedMessages.length
        greenMail.receivedMessages[0].from[0].toString() == 'norepy@dumas.fr'
        greenMail.receivedMessages[0].to == 'from@b.com'
    }

    def 'sends confirmation emails to receiver'() {

        when:
        transactionService.sendToConfirmationEmails(transaction)

        then:
        greenMail.receivedMessages.length
        greenMail.receivedMessages[1].from[0].toString() == 'norepy@dumas.fr'
        greenMail.receivedMessages[1].to == 'to@b.com'
    }
}
