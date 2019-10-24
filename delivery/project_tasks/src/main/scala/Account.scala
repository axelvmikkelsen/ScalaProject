//import exceptions._

class Account(val bank: Bank, initialBalance: Double) {

    class Balance(var amount: Double) {}

    val balance = new Balance(initialBalance)

    // TODO
    // for project task 1.2: implement functions
    // for project task 1.3: change return type and update function bodies
    def withdraw(amount: Double): Either[Double, String] = this.synchronized {
        amount match {
            case amount if amount < 0 => return Right("Can not withdraw a negative amount!")
            case amount if amount <= balance.amount => balance.amount -= amount; return Left(amount);
            case _ =>  return Right("You're too poor")
        }
    }
    def deposit(amount: Double): Either[Double, String] = this.synchronized {
        amount match {
            case amount if amount > 0 => balance.amount += amount; return Left(amount)
            case _ => throw return Right("Can not deposit negative amount!")
        }
    }
    def getBalanceAmount(): Double = this.synchronized { balance.amount }

    def transferTo(account: Account, amount: Double) = {
        bank addTransactionToQueue (this, account, amount)
    }


}
