package es.basallo.secretscapescodetest

class Account {

    String name
    BigDecimal balance = 200.0
    String email

    static hasMany = [transactions: Transaction]
    static mappedBy = [transactions: "from"]

    static transients = ['incomingAndOutgoingTransactions']

    static constraints = {
        name blank: false
        balance min: 0.0
        email email: true, blank: false
    }

    def getIncomingAndOutgoingTransactions() {
        (transactions ?: []) + (Transaction.findAllByTo(this) ?: [])
    }
}
