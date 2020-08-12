package scalafortheimpatient

import scala.collection.{IndexedSeq, SortedMap, immutable, mutable}
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.sys.process
import java.util.Scanner
import java.util.Calendar.MONDAY
import java.util

import scala.collection.immutable.TreeMap

class Chapter4 extends App {

//1. Set up a map of prices for a number of gizmos that you covet. Then produce
//a second map with the same keys and the prices at a 10 percent discount.
def gizmosAtDiscount(): Map[String,Int] = {
  val gizmos = Map (
    "laptop" -> 1500,
    "smartcar" -> 20000,
    "tomatoTimer" -> 10
  )

  gizmos.mapValues(price => price - (price/10))
}
//2. Write a program that reads words from a file. Use a mutable map to count
//how often each word appears. To read the words, simply use a java.util.Scanner:
//val in = new java.util.Scanner(java.io.File("myfile.txt"))
//while (in.hasNext()) process in.next()
////Or look at Chapter 9 for a Scalaesque way.
//  def countOccurences(): mutable.Map[String, Int] = {
//    val words = new mutable.HashMap[String, Int]
//
//
//}
 private def processWords(process: String => Unit): Unit = {
  val in = new Scanner(getClass.getResourceAsStream("/myfile.txt"))
  try {
    while (in.hasNext()) {
      process(in.next())
    }
  }
  finally {
    in.close()
  }
}

//At the end, print out all words and their counts.
//3. Repeat the preceding exercise with an immutable map.
//def wordsNCountsImmutable(): Map[String, Int] = {
//  var words = Map[String, Int]()
//
//  processWords(w => words ++ w -> (words.getOrElse((w,0) + 1))
//    words
//}


//4. Repeat the preceding exercise with a sorted map, so that the words are
//printed in sorted order.

  def countWordsSorted(): SortedMap[String, Int] = {
    var words = SortedMap[String, Int]()
    processWords(w => words ++ w -> (words.getOrElse(w, 0) + 1))
    words

  }

//5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the
//Scala API.

  def countWordsTreeMap(): TreeMap[String, Int] = {
    var words = TreeMap[String, Int]()
    processWords(w => words ++ w -> (words.getOrElse(w, 0) + 1))
    words

  }
//6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and
//similarly for the other weekdays. Demonstrate that the elements are visited
//in insertion order.
  def weekdaysLinkedHashMap(): mutable.Map[String, Int] = {
    val weekdays = mutable.LinkedHashMap[String, Int]("Monday" -> java.util.Calendar.MONDAY)
  weekdays += ("Tuesday" -> java.util.Calendar.TUESDAY,
    "Wednesday" -> java.util.Calendar.WEDNESDAY,
    "Thursday" -> java.util.Calendar.THURSDAY,
    "Friday" -> java.util.Calendar.FRIDAY,
    "Saturday" -> java.util.Calendar.SATURDAY,
    "Sunday" -> java.util.Calendar.SUNDAY)
  weekdays

}
println(weekdaysLinkedHashMap())
//7. Print a table of all Java properties, like this:
//java.runtime.name | Java(TM) SE Runtime Environment
//sun.boot.library.path | /home/apps/jdk1.6.0_21/jre/lib/i386
//java.vm.version | 17.0-b16
//java.vm.vendor | Sun Microsystems Inc.
//java.vendor.url | http://java.sun.com/
//path.separator | :
//java.vm.name | Java HotSpot(TM) Server VM
//You need to find the length of the longest key before you can print the table.

  //properties are a hashtable, so when mapping over a hashtable
  //key value pairs
  //what kind of partial fxn is .map expecting from hashmap => key, value pair
  //extends Hashtable<Object,Object>
  def printJavaProperties():Unit = {
for((k,v) <-  java.lang.System.getProperties) {
  println((k).toString + (v).toString)
  //println calls toString automatically
}
  //looping over getProperties and pulling out tuple k,v
    // pattern matching and for comp combo
  //pattern is 2 elem tuple
  //object looping across is getProperties

  //typically use for comp to build your table

}
//8. Write a function minmax(values: Array[Int]) that returns a pair containing the
//smallest and largest values in the array.
  def minMax(values: Array[Int])= (values.min, values.max)
  println(minMax(Array(1,34,73,36)))
//9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
//the counts of values less than v, equal to v, and greater than v.
 def  lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
  (values.count(_ <  v),values.count(_ == v), values.count(_>v) )

}
  println(lteqgt(Array(1,3,534,4543,12),12))

//10. What happens when you zip together two strings, such as "Hello".zip("World")?
//Come up with a plausible use case.
//"Hello".zip("world")
//  IndexedSeq[(Char, Char)] = Vector(('H', 'w'), ('e', 'o'), ('l', 'r'), ('l', 'l'), ('o', 'd'))

  //This could be useful if characters needed to be compared
// */
}
