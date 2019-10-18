class Bank(val allowedAttempts: Integer = 3) {

    private val transactionsQueue: TransactionQueue = new TransactionQueue()
    private val processedTransactions: TransactionQueue = new TransactionQueue()

    def addTransactionToQueue(from: Account, to: Account, amount: Double): Unit = ???
                                                // TODO
                                                // project task 2
                                                // create a new transaction object and put it in the queue
                                                // spawn a thread that calls processTransactions

    private def processTransactions: Unit = ???
                                                // TOO
                                                // project task 2
                                                // Function that pops a transaction from the queue
                                                // and spawns a thread to execute the transaction.
                                                // Finally do the appropriate thing, depending on whether
                                                // the transaction succeeded or not

    def addAccount(initialBalance: Double): Account = {
        new Account(this, initialBalance)
    }

    def getProcessedTransactionsAsList: List[Transaction] = {
        processedTransactions.iterator.toList
    }

}
