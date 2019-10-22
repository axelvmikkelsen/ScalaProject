<<<<<<< HEAD

object task1 extends App {
=======

object Task1Main extends App {
>>>>>>> 1f608ec0b7c48db27f421d8d613743f071c26f16

    /** 1a **/
    println("a)")

    var numarray = new Array[Int](50)
    var output = "["
    var iter = 1

    for (a <- 1 to 50) {
      numarray(a-1) = a
      if (iter == 50) {
        output += a + ""
      } else {
        output += a + ", "
      }
      iter += 1
    }
    output += "]"
    println(output)

    /** 1b **/
    println("b)")
    def sumList(list:Array[Int]) : Int = {
      var sum:Int = 0

      for (element <- list) {
          sum += element
      }
      return sum
    }
    println("For-loop: " + sumList(numarray))

    /** 1c **/
    println("c)")
    def recursiveSumList(list:Array[Int], sum:Int) : Int = {
      if (list.length == 0) {
        return sum
      }
      return recursiveSumList(list.drop(1), list(0) + sum)
    }

    println("Recursive: " + recursiveSumList(numarray, 0))

    /** 1d **/
    println("d)")
    def nthFib(n:Int) : BigInt = {
      if (n <= 2) {
        return 1
      }
      return nthFib(n-1) + nthFib(n-2)
    }

    println("The 10th Fibonacci number: " + nthFib(10))
    /**
      BigInt allocates space for bigger Integers than the normal Int data type. There's
      still possible to perform operations on BigInt's, but it should only be used
      when expecting a big Integer. It's basic memory management.
    **/
    println("\n")
}
