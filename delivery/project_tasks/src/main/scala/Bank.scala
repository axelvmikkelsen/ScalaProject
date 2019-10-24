class Bank(val allowedAttempts: Integer = 3) {

    private val transactionsQueue: TransactionQueue = new TransactionQueue()
    private val processedTransactions: TransactionQueue = new TransactionQueue()

    def addTransactionToQueue(from: Account, to: Account, amount: Double): Transaction = this.synchronized {
      /**

      **/
      val transaction = new Transaction(transactionsQueue,
                                        processedTransactions,
                                        from,
                                        to,
                                        amount,
                                        allowedAttempts);
      transactionsQueue.push(transaction)
      val thread: Thread = new Thread {
        override def run: Unit = {
          processTransactions
        }
      }
      thread.start
      return transaction
    }


    private def processTransactions: Unit = this.synchronized {
      /**

      **/
      val t: Transaction = transactionsQueue.pop()
      val thread = new Thread {
        override def run = {
          t.run()
          if (t.status == TransactionStatus.PENDING) {
            transactionsQueue.push(t)
            processTransactions
          } else {
            processedTransactions.push(t)
          }
        }
      }
      thread.start
    }

    def addAccount(initialBalance: Double): Account = {
        new Account(this, initialBalance)
    }

    def getProcessedTransactionsAsList: List[Transaction] = {
        processedTransactions.iterator.toList
    }

}
