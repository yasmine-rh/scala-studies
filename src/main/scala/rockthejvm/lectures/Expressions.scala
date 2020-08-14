package rockthejvm.lectures

object Expressions extends App {

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  // (+ - * /) ( ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works w -= *= /=
  println(aVariable)


  // Instructions vs Expressions

  //Instructions (DO)
  //Expressions(VALUE)/type

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  // LOOPS ARE TRASH

  var i = 0
  while (i <  10) {
    println(i)
  }

  //EVERYTHING in Scala is an expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // Side effect examples: println(), whiles, reassigning

  // Code Blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

 //1. WHat is the difference btwn str "hello world" and println("hello world")
  //first is String, second is Unit
 // 2.
  val someValue = {
  2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }






}


