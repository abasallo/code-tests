package es.basallo.secretscapescodetest

import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class TransactionService {

    def mailService

    def execute(Transaction transaction) {
        if (transaction.isFromDifferentFromTo() && transaction.isAmountBelowBalance()) {
            transaction.fromAccountBalance -= transaction.amount
            transaction.toAccountBalance += transaction.amount
            transaction.from.save()
            transaction.to.save()
            transaction.save()
            sendFromConfirmationEmails transaction
            sendToConfirmationEmails transaction
            true
        } else {
            false
        }
    }

    @NotTransactional
    def sendFromConfirmationEmails(Transaction transaction) {

        mailService.sendMail {

            to transaction.fromAccountEmail
            from 'norepy@dumas.fr'
            subject "Wire tranfer confirmation from you account"
            body """Dear ${transaction.fromAccountName},

            A wire transfer of ${transaction.amount} to ${transaction.toAccountName} is been issued from your account.

            Your new balance is ${transaction.fromAccountBalance}.
            """
        }
    }

    @NotTransactional
    def sendToConfirmationEmails(Transaction transaction) {

        mailService.sendMail {

            to transaction.toAccountEmail
            from 'norepy@dumas.fr'
            subject "Wire tranfer confirmation to you account"
            body """Dear ${transaction.toAccountName},

            A wire transfer of ${transaction.amount} from ${transaction.fromAccountName} is been issued to your account.

            Your new balance is ${transaction.toAccountBalance}.
            """
        }
    }
}
