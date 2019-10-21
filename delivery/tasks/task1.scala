
object Main extends App {

    /** 1a **/
    var numarray = new Array[Int](50)
    var output = "["

    var end = false

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
    def sumList(list:Array[Int]) : Int = {
      var sum:Int = 0

      for (element <- list) {
          sum += element
      }
      return sum
    }
    println(sumList(numarray))
}
