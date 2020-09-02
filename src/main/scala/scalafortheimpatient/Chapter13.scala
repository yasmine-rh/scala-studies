package scalafortheimpatient

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


object  Chapter13 extends App {
//  1. Write a function that, given a string, produces a map of the indexes of all
//    characters. For example, indexes("Mississippi") should return a map associating
//  'M' with the set {0}, 'i' with the set {1, 4, 7, 10}, and so on. Use a mutable map
//    of characters to mutable sets. How can you ensure that the set is sorted?
//    2. Repeat the preceding exercise, using an immutable map of characters to lists.
//m {0}, i{1,4,}, s{3..}, p{8,9}

def indices(str: String): mutable.Map[Char, mutable.SortedSet[Int]] = {

  var map =  mutable.Map.empty[Char, mutable.SortedSet[Int]]
  //instead of new can use .empty
  //more fxnal way of declaring

  for (i <- 0 until str.length) {
    map.update(str(i), map.getOrElse(str(i), mutable.SortedSet.empty[Int]) + i)
    //set of [A] + A value, will append to set
  }
  map
}
  indices("Tomato")

//
//  def indiciesF(str: String):
  //set is sorted bc declared a sorted set, but should use sorted set to ensure answer
  //ordered vs sorted
  // -specific sequence (sorted)
  // -ordered means that they are in some order

//  3. Write a function that removes every second element from a ListBuffer. Try it
//    two ways. Call remove(i) for all even i starting at the end of the list. Copy every
//    second element to a new list. Compare the performance.

  def removeEveryOther(listBuff: ListBuffer[Int]): ListBuffer[Int] = {
    val newList = ListBuffer.empty[Int]
   for (i <- listBuff.indices if (i % 2 == 0))
     newList += listBuff(i)
    newList
  }
  removeEveryOther(ListBuffer(1,24,5,65,3,6))


  def removeEveryOther2(listBuff: ListBuffer[Int]): ListBuffer[Int] = {
    for (i <- listBuff.indices.reverse if (i % 2 == 1))
      listBuff.remove(i)
    listBuff
  }
  removeEveryOther2(ListBuffer(1,24,5,65,3,6))


//  4. Write a function that receives a collection of strings and a map from strings
//  to integers. Return a collection of integers that are values of the map corresponding to one of the strings in the collection. For example, given Array("Tom",
//    "Fred", "Harry") and Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5), return Array(3, 5).
//    Hint: Use flatMap to combine the Option values returned by get.
  def mapValues(strColl: Array[String] , map: Map[String, Int]) = {
      strColl.flatMap(map.get)
  //if this was production code, probably better to use .getOrElse w new exception
}
  mapValues(Array("Tom","Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" ->  5))
//  5. Implement a function that works just like mkString, using reduceLeft.

  def mkString2(str: Array[String], separate: String = ", "): Unit = {
    str.reduceLeft((a, b) => a + separate + b)
  }
  mkString2(Array("hi", "hello", "yo"), " ")

//  6. Given a list of integers lst, what is (lst :\ List[Int]())(_ :: _)? (List[Int]() /:
//    lst)(_ :+ _)? How can you modify one of them to reverse the list?
  val lst = List(1,2,3,4)

  val reverse = (List[Int]() /: lst)(_ :: _)

// They are all the same list

//    7. In Section 13.10, “Zipping,” on page 187, the expression (prices zip quantities)
//  map { p => p._1 * p._2 } is a bit inelegant. We can’t do (prices zip quantities) map
//    { _ * _ } because _ * _ is a function with two arguments, and we need a
//    function with one argument that is a tuple. The tupled method of the Function
//  object changes a function with two arguments to one that takes a tuple. Apply
//  tupled to the multiplication function so you can map it over the list of pairs.

//  map { p => p._1 * p._2 }


  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)

  def sum (prices: List[Double], quantities: List[Int]): List[Double] = {
    (prices, quantities).zipped map{_ * _}
  }
  sum(prices, quantities)


//  8. Write a function that turns an array of Double values into a two-dimensional
//  array. Pass the number of columns as a parameter. For example, with Array(1,
//    2, 3, 4, 5, 6) and three columns, return Array(Array(1, 2, 3), Array(4, 5, 6)).
//    Use the grouped method.

  def twoD(arr: Array[Int], columns: Int) = {
    arr.grouped(columns).toList
  }
  twoD(Array(1, 2, 3, 4, 5, 6), 3)

//  9. The Scala compiler transforms a for/yield expression
//  for (i <- 1 to 10; j <- 1 to i) yield i * j
//  to invocations of flatMap and map, like this:
//  (1 to 10).flatMap(i => (1 to i).map(j => i * j))
//  Explain the use of flatMap. Hint: What is (1 to i).map(j => i * j) when i is 1, 2, 3?

  //If flatMap wasn't used, the collection would be nested. It is hardly ever useful to return a nested collection.

  //FlatMap is used to flatten lists and make them easier to read
//    What happens when there are three generators in the for/yield expression?
//    10. The method java.util.TimeZone.getAvailableIDs yields time zones such as Africa/
//    Cairo and Asia/Chungking. Which continent has the most time zones? Hint: groupBy.
  val id = java.util.TimeZone.getAvailableIDs.toSeq

  def findContinent(id: String): String = {
    id.split('/').head
  }

  //partial fxn obj that wraps around fxn

  def countZonesByCont() = {
   id.groupBy(id => findContinent(id)).maxBy(a => a._2.length)._1
    //._1 returns the key from k v pair from maxBy

  }
//  11. Harry Hacker reads a file into a string and wants to use a parallel collection
//    to update the letter frequencies concurrently on portions of the string. He
//  uses the following code:
//  val frequencies = new scala.collection.mutable.HashMap[Char, Int]
//  for (c <- str.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1
//  Why is this a terrible idea? How can he really parallelize the computation?
//  (Hint: Use aggregate.)

  //count characters
  //transform into map and aggregate the maps together


    val frequencies = new scala.collection.mutable.HashMap[Char, Int]
//    for (c <- str.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1

val res = frequencies.par.aggregate((0,0))(frequencies, res) =>()





}


