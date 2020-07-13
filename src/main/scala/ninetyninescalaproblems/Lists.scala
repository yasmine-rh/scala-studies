package ninetyninescalaproblems

import java.security.KeyStore.TrustedCertificateEntry

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class Lists extends App {

  /* Find the last element of a list.
    Example:
    scala> last(List(1, 1, 2, 3, 5, 8))
  res0: Int = 8
  */

  //head, tail, isEmpty
  //

  def last[T](list: List[T]): T = {
    if (list.isEmpty) throw new NoSuchElementException("List is empty, please use valid input")
    else if (list.length == 1) list.head
    else last(list.tail)
  }

  last(List(1, 1, 2, 3, 5, 8))
  List(1).last

  /* Find the last but one element of a list.
    Example:
    scala> penultimate(List(1, 1, 2, 3, 5, 8))
  res0: Int = 5*/
  def penultimate[T](list: List[T]): T = {
    if (list.isEmpty) throw new NoSuchElementException("List is empty, please use valid input")
    else if (!(list.length >= 2)) throw new NoSuchElementException("List isn't long enough, please use valid input")
    else list(list.length - 2)
  }

  penultimate(List(1, 1, 2, 3, 5, 8))

  def penultimateRecursive[T](list: List[T]): T = {
    list match {
      case List(first, last) => first
      case first :: second :: rest => penultimateRecursive(second :: rest)
      case _ => sys.error("\"List is empty, please use valid input\"")
    }
  }

  penultimateRecursive(List(1, 1, 2, 3, 5, 8))

  //better to step thru and retrieve value rather than grabbing index

  /*
  Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:

scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
  */
  @scala.annotation.tailrec
  //telling compiler don't use stack when running this fxn
  //also checks that is tail recursive
  final def nth[T](list: List[T], n: Int): T = {
    //if not final someone can override and remove tail recursion
    //bc tail rec is in body of function, if extended must be tail recursive too
    //but cannot be guaranteed so has to be marked final so cannot be changed
    //or has to be marked private so cannot be used
    //or can remove tail recursive tag

    if (list.isEmpty) throw new NoSuchElementException("List is empty, please use valid input")
    else if (n > list.length) throw new IndexOutOfBoundsException("Nth element does not exist in list")
    else if (n == 0) list.head
    else nth(list.tail, n - 1)
  }

  nth(List(1, 1, 2, 3, 5, 8), 12)

  /*linked list, passed down nodes would
  be the best way to improve efficiency
   */


  //go thru the list(0)
  //list.head

  //.head
  //.tail
  //.isEmpty
  //.length

  /*
   Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6

purpose is to create method that does this
   */
  def length[T](list: List[T]): Int = {
    @tailrec
    def helper(list: List[T], counter: Int): Int = {
      if (list.isEmpty) counter
      else helper(list.tail, counter + 1)
    }

    helper(list, 0)
  }

  length(List(1))


  //while !empty
  //while loop v side-effect-y
  //can end up losing value when working w multiple threads


  /*
  Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
   */
  //1

//
//  def reverse[T](list: List[T]): List[T] = {
//    @tailrec
//    def helper(list: List[T], reversed: ListBuffer[T]): List[T] = {
//      if (list.isEmpty) throw new NoSuchElementException("List is empty, please use valid input")
//      else if (list.last == 0) reversed
//      else helper(reversed += list.last, reversed)
//
//      helper(list, (ListBuffer()))
//    }
//
//    reverse(List(1, 2, 3, 4))
//  }

  def reverseRecursive[T](list: List[T]): List[T] = {
    list match {
      case Nil => Nil
      case head :: tail => reverseRecursive(tail) ::: List (head)
    }
  }
  reverseRecursive(List(1, 2, 3, 4))
  ///":::" prepends whole list, while "::" prepends single item




  /*
  Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
   */

  //.head
  //.tail
  //.isEmpty
  //.length

def isPalindrome[T](list: List[T]): Boolean = {
  if (list.isEmpty) throw new NoSuchElementException("List is empty, please use valid input")
  else if (reverseRecursive(list) == list) true
  else false
}

//def isPalindromeRecursive[T](list: List[T]): Boolean = {
//  case Nil => Nil
//  case

//}
  isPalindrome(List(1,2,3,4))
  isPalindrome(List(1,1,1,1))
//  isPalindromeRecursive(List(1,2,3,4))
//  isPalindromeRecursive(List(1,1,1,1))
  /*
  P07 (**) Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
   */
//  def flatten[T](list: List[T]): List[T]= {
//    list.groupBy()
//  }

// P08 Eliminate consecutive duplicates of list elements.
  //If a list contains repeated elements they should be replaced with a single copy of the element.
  // The order of the elements should not be changed.
  //Example:
  //scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)


}