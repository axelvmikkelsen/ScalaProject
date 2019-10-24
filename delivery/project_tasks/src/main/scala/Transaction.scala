//import exceptions._
import scala.collection.mutable

object TransactionStatus extends Enumeration {
  val SUCCESS, PENDING, FAILED = Value
}

class TransactionQueue {

    // TODO
    // project task 1.1
    // Add datastructure to contain the transactions
    private val queue = new mutable.Queue[Transaction]

    // Remove and return the first element from the queue
    def pop(): Transaction = this.synchronized {
        this.queue.dequeue
    }

    // Return whether the queue is empty
    def isEmpty(): Boolean = this.synchronized{
        this.queue.isEmpty
    }

    // Add new element to the back of the queue
    def push(t: Transaction): Unit = this.synchronized {
        this.queue.enqueue(t)
    }

    // Return the first element from the queue without removing it
    def peek(): Transaction = this.synchronized {
        this.queue.head
    }

    // Return an iterator to allow you to iterate over the queue
    def iterator(): Iterator[Transaction] = this.synchronized {
        this.queue.iterator
    }
}

class Transaction(val transactionsQueue: TransactionQueue,
                  val processedTransactions: TransactionQueue,
                  val from: Account,
                  val to: Account,
                  val amount: Double,
                  val allowedAttemps: Int) extends Runnable {

  var status: TransactionStatus.Value = TransactionStatus.PENDING
  var attempt = 0

  def getTransactionStatus(): TransactionStatus.Value = { status }

  override def run: Unit = {

      def doTransaction() = {

        this.attempt += 1

        lazy val withdraw = from.withdraw(amount)
        lazy val deposit = to.deposit(amount)

        withdraw match {
            case Right(string) => Unit
            case Left(number) => deposit match {
              case Right(string) => Unit
              case Left(number) => this.status = TransactionStatus.SUCCESS
            }
          }

        if (this.attempt == allowedAttemps && this.status == TransactionStatus.PENDING) {
          this.status = TransactionStatus.FAILED
        }

      }

      if (status == TransactionStatus.PENDING) {
          this.synchronized{ doTransaction }
          Thread.sleep(20) // you might want this to make more room for
                           // new transactions to be added to the queue
      }


    }
}
