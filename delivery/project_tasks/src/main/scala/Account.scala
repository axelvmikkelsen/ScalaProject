import exceptions._

class Account(val bank: Bank, initialBalance: Double) {

    class Balance(var amount: Double) {}

    val balance = new Balance(initialBalance)

    // TODO
    // for project task 1.2: implement functions
    // for project task 1.3: change return type and update function bodies
    def withdraw(amount: Double): Unit = ???
    def deposit (amount: Double): Unit = ???
    def getBalanceAmount: Double       = ???

    def transferTo(account: Account, amount: Double) = {
        bank addTransactionToQueue (this, account, amount)
    }


}
