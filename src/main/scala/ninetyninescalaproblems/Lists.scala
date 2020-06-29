package ninetyninescalaproblems

import scala.annotation.tailrec

class Lists extends App  {
 /* Find the last element of a list.
    Example:
    scala> last(List(1, 1, 2, 3, 5, 8))
  res0: Int = 8
  */

  //head, tail, isEmpty
  //

  def last[T](list: List[T]) : T = {
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
  def penultimate[T](list: List[T]) : T = {
    if (list.isEmpty) throw new NoSuchElementException("List is empty, please use valid input")
    else if (!(list.length >= 2)) throw new NoSuchElementException("List isn't long enough, please use valid input")
    else  list(list.length - 2)
  }
  penultimate(List(1, 1, 2, 3, 5, 8))

  def penultimateRecursive[T](list: List[T]) : T = {
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
   final def nth[T](list: List[T], n: Int) : T = {
    //if not final someone can override and remove tail recursion
    //bc tail rec is in body of function, if extended must be tail recursive too
    //but cannot be guaranteed so has to be marked final so cannot be changed
    //or has to be marked private so cannot be used
    //or can remove tail recursive tag

      if (list.isEmpty ) throw new NoSuchElementException("List is empty, please use valid input")
      else if (n > list.length) throw new IndexOutOfBoundsException("Nth element does not exist in list")
      else if (n == 0) list.head
      else nth(list.tail, n - 1)


  }

  nth(List(1, 1, 2, 3, 5, 8),12)

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

//  def reverse[T](list: List[T]): List[T] = {
//    if (list.isEmpty) throw new NoSuchElementException("List is empty, please use valid input")
//    else (reverse(list.length - 1))
//  }


  /*
  Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
   */

}