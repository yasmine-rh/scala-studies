package rockthejvm.exercises

abstract class MyList {

  /*
    head = first element of the list
    tail (pointer) = remainder of the list
    isEmpty = is this list empty?
    add (Int) => new List with this element added
    toString => a string representation of the list
   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  protected def printElement: String //polymorphic call
  override def toString: String = "[" + printElement + "]" //present in AnyRef



}

object Empty extends MyList{
  //objects can extend classes
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElement: String = ""
}

class Cons(h: Int, t: MyList ) extends MyList {
  //this Cons will compose value with other list
  //this is what a linked list is composed of a value and the rest of a list
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElement: String = {
    if (t.isEmpty) " " + h
    else h + " " + t.printElement
  }

}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head) //list is added to the head
  println(list.isEmpty)
  println(list.toString)


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
