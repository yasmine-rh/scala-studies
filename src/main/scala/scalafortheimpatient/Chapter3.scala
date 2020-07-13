package scalafortheimpatient

import scala.util._
import scala.collection.mutable._

class Chapter3 {

//  Exercises
//  1. Write a code snippet that sets a to an array of n random integers between 0
//  (inclusive) and n (exclusive).

  def randomIntArr(n: Int): Array[Int] = {
    val a = new Array[Int](a)
    for (i <- a.indices) {
      a(i) = Random.nextInt(n)
    }
    a
  }
  randomIntArr(3)

//  2. Write a loop that swaps adjacent elements of an array of integers. For example,
//  Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).

  def swapElem(arr: Array[Int]): Array[Int] = {
    for (i <- 1 until arr.length if (i % 2)!= 0) {
      val plchldr = arr(i - 1)
      arr(i -1 ) = arr(i)
      arr(i) = plchldr
    }
    arr
  }
  swapElem(Array(1, 2, 3, 4, 5))
//  3. Repeat the preceding assignment, but produce a new array with the swapped
//    values. Use for/yield.
def swapElemYield(arr: Array[Int]) = {
  for(i <- arr.indices) yield arr(
    if ((i % 2) == 0)
      if ( i + 1 == arr.length) i
      else i +1
    else i -1

  )
}
  swapElemYield(Array(1, 2, 3, 4, 5))


//  4. Given an array of integers, produce a new array that contains all positive
//  values of the original array, in their original order, followed by all values that
//  are zero or negative, in their original order.
  def posiThenNeg(arr: Array[Int]): Array[Int] = {
  val len = arr.length
  val arr2 = new Array[Int](len)
  var index = 0
  for (i <- 0 until len if arr(i) > 0) {
    arr2(index) = arr(i)
    index += 1
  }
  if (index < len) {
    for (i <- 0 until len if arr(i) <= 0) {
      arr2(index) = arr(i)
      index += 1

    }

  }
  arr2

}
  posiThenNeg(Array(1,-3,2,-6,5,5,5,-1))

//  5. How do you compute the average of an Array[Double]?
  def findAvg(arr: Array[Double]): Double = {
    arr.sum/arr.length
  }
  findAvg(Array(2.1,2.2,2.3))
//
//  6. How do you rearrange the elements of an Array[Int] so that they appear in
//    reverse sorted order? How do you do the same with an ArrayBuffer[Int]?


//  7. Write a code snippet that produces all values from an array with duplicates
//  removed. (Hint: Look at Scaladoc.)

//  8. Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on
//  page 34 using the drop method for dropping the index of the first match. Look
//  the method up in Scaladoc.

//  9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
//  that are in America. Strip off the "America/" prefix and sort the result.
//  10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with
//  the call
//  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
//  Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor
//  and get the return value as a Scala buffer. (Why this obscure class? It’s hard
//    to find uses of java.util.List in the standard Java library.)
}
