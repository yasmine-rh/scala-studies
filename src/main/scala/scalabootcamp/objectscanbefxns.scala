package scalabootcamp

import com.sun.org.apache.xpath.internal.functions.FunctionDef1Arg

object objectscanbefxns extends App {

  {
    class Square { def apply(x: Double): Double = x * x }
    val sqr = new Square
    sqr(5.0)
  }
  //result should be 25.0



  //exercises
  def double(num: Int): Int = {
    num * 2
  }

  double(5)
  double(200)

  def plusOne(num: Int): Int = {
    num + 1
  }

  plusOne(1)
  plusOne(365)

plusOne(1)
def x = plusOne _ andThen plusOne
  //executes left fxn then right -- applies right to result of left
def e = plusOne _ compose plusOne
    //executes right fxn then left -- applies left to result of right


def add(num: Int, num2: Int): Int = num + num2

val t = add _ curried _
  t(12)(13)
  val s = t(1)
  s(2)
  //have to curry if fxn takes function as param
  //mainly for decomposing larger fxns into smaller functions

}
