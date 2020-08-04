package rockthejvm.lectures

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    //=> tells compiler param will be called by name
    println("By name: " + x)
    println("By name: " + x)
  }

  calledByName(System.nanoTime())
  calledByValue(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)
  //by name

//  printFirst(infinite(), 34)
  //will cause stack overflow error
  printFirst(34, infinite())

}
