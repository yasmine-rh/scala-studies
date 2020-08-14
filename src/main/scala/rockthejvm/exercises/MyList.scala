package rockthejvm.exercises

abstract class MyList[+A] {

  /*
    head = first element of the list
    tail (pointer) = remainder of the list
    isEmpty = is this list empty?
    add (Int) => new List with this element added
    toString => a string representation of the list
   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElement: String //polymorphic call
  override def toString: String = "[" + printElement + "]" //present in AnyRef


  //higher-order fxns either receive fxns as params or return fxns as result
  //use fxns as first class values
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B] //concat

  //HOFS

  def foreach(f: A => Unit): Unit
  def sort(compare: (A,A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip: (A,B) => C): MyList[C]
  def fold[B](start: B)(operator: (B,A) => B): B



}

case object Empty extends MyList[Nothing]{
  //objects can extend classes
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElement: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

//hofs

  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing , Nothing) => Int): Empty.type = Empty

  def zipWith[B, C](list: MyList[B], zip: (Nothing,B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("lists don't have same len")
    else Empty
  }

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start

}

case class Cons[+A](h: A, t: MyList[A] ) extends MyList[A] {

  //this Cons will compose value with other list
  //this is what a linked list is composed of a value and the rest of a list
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElement: String = {
    if (t.isEmpty) " " + h
    else h + " " + t.printElement
  }

  /*
  [1,2,3].filter(n % 2 == 0)
  [2,3].filter(n % 2 == 0)
  new Cons(2, [3].filter(n % 2 == 0))
  = new Cons(2, Empty.filter(n%2 ==0))
  = new Cons

   */

  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons(h, t.filter(predicate)) //if head passes predicate, it will be included in result
    else t.filter(predicate) //head is not incl in result bc doesn't pass filter
  }

  /*
  [1,2,3].map(n*2)
  = new Cons(2, [2,3].map(n*2))
  = new Cons(2, new Cons(4,[3].map(n*2))
  = new Cons(2, new Cons,(4, new Cons(6, Empty.map(n*2)))
  = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */

  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  /*
  [1,2] ++ [3,4,5]
  = new Cons (1,[2] ++ [3,4,5])
  = new Cons(1, new Cons92, Empty ++ [3,4,5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  /*
  [1,2].flatMap(n => [n , n +1])
  = [1,2] ++ [2].flatMap(n => n, [n+1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n + 1])
  = [1,2] ++ [2,3] ++ Empty
  =[1,2,2,3]
   */

  //HOFS
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("lists don't have same len")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))

  /*
  [1,2,3].fold (+) =
  = [2,3].fold(1)(+) =
  =[3].fold(3)(+) =
  =[].fold(6)(+)
   */

  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }

  //trait MyPredicate[-T] { //T => Boolean
  //  def test(elem: T): Boolean
  //}
  //
  //trait MyTransformer[-A, B] { // A => B
  //  def transform(elem: A): B
  //}
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(elem => elem).toString)

  println(listOfIntegers.filter(_ % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println((listOfIntegers.flatMap(elem => new Cons(elem + 1, Empty))).toString)

  println(cloneListOfIntegers == listOfIntegers) //true bc case class

  listOfIntegers.foreach(println)

  println(listOfIntegers.sort((x,y)=> y-x))

  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-"  + _))

  println(listOfIntegers.fold(0)(_+_))


  //FOR-COMP

  println(for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string)


}

/*takeaways
scala offers class-based inheritance
  -access modifiers
  - need to pass in constructor arguments to parent class
derived classes can override members or methods
reuse parent fields/methods with super
prevent inheritance with final and sealed
abstract classes
traits inheriting from a class and multiple traits
 */

/*
use the same code on many potientially unrelated types
generic methods
multiple type params
Variance: if B extends A, should list[B] extend list[a]?
trait List[+a] yes covariant
trait list[a] no invariant - default
trait list [-a] hell no! contravariant
bounded types
class Car
class Supercar extends Car
class Garage[T <:](car: T)
an annoying variance problem
 */
