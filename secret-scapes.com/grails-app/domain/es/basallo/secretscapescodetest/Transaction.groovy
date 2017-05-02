package es.basallo.secretscapescodetest

class Transaction {

    static belongsTo = [from: Account]
    Account to
    BigDecimal amount

    static transients = ['fromAccountEmail', 'toAccountEmail', 'fromAccountName', 'toAccountName',
                         'fromAccountBalance', 'toAccountBalance']

    static constraints = {
        amount min: 0.01
    }

    def isAmountBelowBalance() {
        amount <= from.balance
    }

    def isFromDifferentFromTo() {
        from != to
    }

    def getFromAccountEmail() {
        from.email
    }

    def getToAccountEmail() {
        to.email
    }

    def getFromAccountName() {
        from.name
    }

    def getToAccountName() {
        to.name
    }

    def getFromAccountBalance() {
        from.balance
    }

    def getToAccountBalance() {
        to.balance
    }

    def setFromAccountBalance(balance) {
        from.balance = balance
    }

    def setToAccountBalance(balance) {
        to.balance = balance
    }
}
