package rockthejvm.lectures.part3fp

import scala.util.Random

object Sequences extends App {
  //Seq
  /*a very general interface for data structures that:
    - have a well defined order
    - can be indexed
  support various operations:
    - apply, iterator, length, reverse for indexing and iterating
    - concat, appending, prepending
    - a lot of others: grouping, slicing, etc
   */
  val aSequence = Seq(1,3,4,2)
  println(aSequence)
  println(aSequence.reverse)
//  println(aSequence.apply(2))
  println(aSequence(2)) //same as above
  println(aSequence ++ Seq(5,7,4))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq[Int] = 1 until 10 //a collection
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //Lists
  /*
  Immutable
  A LinearSeq immutable linked list
  - head, tail, isEmpty methods are fast O(1)
  - most operations are O9n): length, reverse

  Sealed - has 2 subtypes
  - obj Nil (empty)
  - class ::
   */
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  println(prepended)
  val prepended2 = 42 +: aList //samesies
  println(prepended2)
  val append = prepended2 :+ 12
  println(append)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString(("-|-")))

  //ARRAYS
  /*
  Equivalent of simple Java arrays
  - can be manually constructed with predefined lengths
  - can be mutated(updated in place)
  - are interoperable w Java's T[] arrays
  - indexing is fast
  WHERE's THe Seq?!*
   */

  val numbers = Array(1,2,3,4)
  val threeElems = Array.ofDim[String](3)
  threeElems.foreach(println)

  //mutation
  numbers(2) = 0 // syntactic sugar for numbers.update(2,0)
   // updates index 2 w value 0
  println(numbers.mkString(" "))

  //arrays and seq
  val numbersSeq: Seq[Int] = numbers // IMPLICIT CONVERSION
  println(numbersSeq)

  //Vectors
  /*
  the default implementation for immutable seq
  - effectively constant indexed read and write O (log 32(n)
  - fast element addition: append/prepend
  - implemented as fixed-branch trie (branch factor 32)
  - good performance for lrg sz
   */
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  //vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      //operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns

  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector =(1 to maxCapacity).toVector

  // keeps reference to tails
  // updating an elem in middle takes time
  println(getWriteTime((numbersList)))
  // the depth of the tree is small
  // it needs to replace an entire 32-elem chunk
  println(getWriteTime(numbersVector))


}
