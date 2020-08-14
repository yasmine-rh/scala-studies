package rockthejvm.lectures.part3fp

object AnonymousFunctions extends App {

//  val doubler = new Function1[Int, Int] {
//    override def apply(x: Int) = x * 2}

  //anon fxn (LAMBDA)
  val doubler: Int => Int = (x) => x * 2 //same as above
  val doubler2 = (x: Int) => x * 2
  // if compiler already knows int => int, don't have to give type params to params

  //multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b : Int) => a + b

  // no params
  val justDoSomething:  () => Int = () => 3

  println(justDoSomething) // function itself
  println(justDoSomething()) // the call (lambdas must be called w parentheses)

  //curly braces w lambdas

  val stringToInt = { (str: String) =>
    str.toInt
  }

  // mroe syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int =  _ + _ //equiv to (a,b) => a + b

  /*
  1. MyList: replace all functionX calls w lambdas
  2. rewrite the "special" adder as an anon
   */

  val superAdd = (x: Int) => (y: Int) => x + y


  /*
  takeaways:
  instead of passing anon fznx instances every tome
  - cumbersome
  - still oop!

  instead:
  use lambdas!
  underscores!

   */


}
