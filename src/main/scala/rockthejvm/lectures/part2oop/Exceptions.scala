package rockthejvm.lectures.part2oop

object Exceptions extends App {

  val x: String = null
 // println(x.length) throws  NullPointerException and nothing to catch exception
  //throwing and catching exceptions
  // / throw new NullPointerException  this expression  intentionally throws exception
//val aWeirdVal: String = throw new NullPointerException
  //NullPointerException is a class

  //throwable classes extend the Throwable class
  //Exception and Error are the major Throwable subtypes
  //exceptions denote something wrong w program
  //error is something wrong w system

  //2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you!")
    else 42

     val potentialFail = try {
      //code that might fail
      getInt(false)
    } catch {
      case e: RuntimeException => 42
//      case e: NullPointerException => println("caught a runtime exception") //will crash, but 'finally' still prints to console
    } finally {
      //code that will get executed no matter what
       //optional
       //doesnt influence the return type of expression
       //use finally only for side effects
      println("finally")
    }

println(potentialFail)


  //how to define your own exceptipns
  class MyException extends Exception
  val exception = new MyException

  throw exception

  /*
  1. Crash program with an OutOfMemoryError
  2. Crash w stackoverflow
  3. PocketCalculator
  - add(x,y)
  - multiply(x,y)
  - divide(x,y)
  - subtract(x,y)

  Throw custom exception if something happens
  - overflowException if add(x,y) exceeds Int.MAX_VALUE
  - underflowException if subtract exceeds Int. MIN_VALUE
  - mathCalcException for division by 0

   */

//  val array = Array.ofDim(Int.MaxValue) OOM

//  def infinite: Int = 1 + infinite
//  val noLimit = infinite SO
class OverFlowException extends RuntimeException
class UnderFlowException extends RuntimeException
class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x-y
      if(x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if  (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new UnderFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x/y

    }

  }
//  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 10))

}
