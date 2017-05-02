package es.basallo.secretscapescodetest

class AccountController {

    static defaultAction = "transactions"

    def transactionService

    // In a real environment, as number of actions in every controller would be much higher, it would probably be a good
    // idea to split this one into AccountController and TransactionController and use standard naming for actions: list,
    // create and for the corresponding views; leading to a better design
    // In this case, for simplicity, I have maintained suggested names for provided views and kept everything in one
    // controller.

    def transactions() {

        // TODO - Production code should implement some pagination mechanism with page size limited to protect database

        // Acceptance criteria number 2 - I see all transactions for the account that I selected
        // Is been interpreted as incoming and outgoing from selected account, though model includes just strong
        // relation with those outgoing that should be cascade purged in case source account is deleted.

        def accounts = Account.list()
        def balance
        def incomingAndOutgoingTransactions = []

        if (accounts) {
            balance = accounts.first().balance
            incomingAndOutgoingTransactions = accounts.first().incomingAndOutgoingTransactions
        }

        if (params.from) {
            balance = accounts[params.int('from') - 1].balance
            incomingAndOutgoingTransactions = accounts[params.int('from') - 1].incomingAndOutgoingTransactions
        }

        [accounts: accounts, balance: balance, incomingAndOutgoingTransactions: incomingAndOutgoingTransactions]
    }

    def pay() {

        // TODO - Production code should implement some pagination mechanism with page size limited to protect database

        [accounts: Account.list()]
    }

    def payExecution() {

        def transaction = new Transaction(from: params.from, to: params.to, amount: params.amount)
        if (transaction.validate() && transactionService.execute(transaction)) {
            flash.message = message(code:"accountController.flash.message.success")
            redirect(action: 'transactions')
        } else {
            flash.message = message(code:"accountController.flash.message.failure")
            render view: 'pay', model: [accounts: Account.list(), transaction: transaction]
        }
    }
}


