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
  println(s"The thread's name is: $thread \n");

    // Task 2b and 2c) 
    /**
    This phenomenon is called race-condition in programming. 
    Two or more threads "compete" for the same resource, and the output 
    depends on whoever reaches the value first. (Non-deterministic.)
    In this example the "readCounter"-thread might read the counter value before
    the "increaseCounter"-thread reaches it. This can solved by handling the threads
    by .join() method, which tells the threads to complete before the main-thread(the program)
    continuous. And by the use of synchronization, which makes the critical section a mutex.

    An example where it can be problematic is if the program is stuck in a while/for-loop, 
    with an exit condition. If the two or more threads are not coooperating 
    (and always racing to change the value), the value might never reach the exit condition, 
    and we are stuck in an infinite loop. 
    
     */
    private var counter: Int = 0

    def increaseCounter(): Unit =  this.synchronized /*<--- changed for atomicity */ {
        counter += 1
        println("Incremented the counter\n")
    }

    def printCounter(): Unit = {
        println(s"The value of the counter is $counter")
    }

    val thread1 = threadFunction(increaseCounter())
    val thread2 = threadFunction(increaseCounter())
    val thread3 = threadFunction(printCounter())

    thread1.start()
    thread2.start()

    thread1.join()  // Awaits for the computation to finish
    thread2.join()  // Awaits for the computation to finish

    thread3.start()

}

 // Task 2d)
/**

A deadlock is a general situation in which two or more executions 
wait for each other to complete an action before proceeding. 
Both threads have access to a mutex value that the other thread needs
to continue the operation. So they are both locked out, and waiting "forever".

To prevent deadlock a total order of acquiring resources needs to be established.
As whenever two (or more) threads acquire resources in the same order, 
there is no danger of deadlock.

*/

// Example of a deadlock using lazy val (by running LazyValDeadLock)
object LazyValDeadLock extends App {
  println((new Z).Y)
}

class Z {
  lazy val X = 0
  lazy val Y = {
    // 'mentioning' X here solves the problem:
    // X
    for (i <- 0 until 2 par) yield {
      println(i)
      X
    }
  }
}