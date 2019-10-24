class Bank(val allowedAttempts: Integer = 3) {

    private val transactionsQueue: TransactionQueue = new TransactionQueue()
    private val processedTransactions: TransactionQueue = new TransactionQueue()

    def addTransactionToQueue(from: Account, to: Account, amount: Double): Transaction = this.synchronized {
      /**

      **/
      val transaction = new Transaction(transactionsQueue,processedTransactions,from,to,amount,allowedAttempts);
      transactionsQueue.push(transaction)
      transaction.run()

      return transaction

    }


    private def processTransactions(): Unit = this.synchronized {
      /**

      **/
      if (transactionsQueue.isEmpty()) {
        println("No transactions in queue")
      }
      val t: Transaction = transactionsQueue.pop()
      if (t.getTransactionStatus() == PENDING) {
        transactionsQueue.push(t)
        processTransactions()
      } else {
        processedTransactions.push(t)
      }

    }
      // TOO
      // project task 2
      // Function that pops a transaction from the queue
      // and spawns a thread to execute the transaction.
      // Finally do the appropriate thing, depending on whether
      // the transaction succeeded or not

    def addAccount(initialBalance: Double): Account = {
        println("Account added!")
        new Account(this, initialBalance)
    }

    def getProcessedTransactionsAsList: List[Transaction] = {
        processedTransactions.iterator.toList
    }

}

object BankMain extends App {
  val bank: Bank = new Bank()
  val account1: Account = bank.addAccount(100.0)
  val account2: Account = bank.addAccount(150.0)
  // println("Account 1 Balance = " + account1.getBalanceAmount);
  // println("Account2 balance = " + account2.getBalanceAmount);

  // println(account1.getBalanceAmount())
  // println(account2.getBalanceAmount())

  val transaction: Transaction = bank.addTransactionToQueue(account1,account2, 50.0)

  // println(account1.getBalanceAmount())
  // println(account2.getBalanceAmount())

  // Process-queue
  bank.processTransactions()

}
