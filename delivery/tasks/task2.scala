
object Task2Main extends App {

  /** Task 2a)
    * A given function is passed to a thread, ready to execute.
    *
    * :param fx: The function executed in the thread
    *
    * :return: The not yet started thread
  **/

  def threadFunction(fx: Unit) : Thread = {
    val thread = new Thread {
      override def run() {
        fx
      }
    }
    return thread;
  }

  val thread = threadFunction(println("Running thread"));
  println(s"The thread's name is: $thread");

  /** Task 2b)
    *
    *
    *
    *
  **/

  private var counter: Int = 0
  def increaseCounter(): Unit = {
    counter += 1
    println("Incremented the counter")
  }

  def printCounter(): Unit = {
    println(s"The value of the counter is $counter")
  }

  val thread1 = threadFunction(increaseCounter())
  val thread2 = threadFunction(increaseCounter())
  val thread3 = threadFunction(printCounter())

  thread1.start()
  thread2.start()


  thread3.start()

  /**
  thread1.join()
  thread2.join()
  **/

  //println(s"The counter is $counter")
}
