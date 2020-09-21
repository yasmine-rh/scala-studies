package scalafortheimpatient

import com.sun.source.tree.BinaryTree

class Chapter14 {
//  1. Your Java Development Kit distribution has the source code for much of the
//  JDK in the src.zip file. Unzip and search for case labels (regular expression
//  case [^:]+:). Then look for comments starting with // and containing [Ff]alls?
//  thr to catch comments such as // Falls through or // just fall thru. Assuming
//  the JDK programmers follow the Java code convention, which requires such
//  a comment, what percentage of cases falls through?



//  2. Using pattern matching, write a function swap that receives a pair of integers
//    and returns the pair with the components swapped.
  def swap(pair: (Int,Int)): (Int, Int) =  pair match {
    case(a, b) => (b,a)

}
  swap(1,2)
//  3. Using pattern matching, write a function swap that swaps the first two elements
//    of an array provided its length is at least two.
  def swapElems(arr: Array[Int]): Array[Int] = arr match {
    case Array(a,b,_*) if (arr.length >= 2) =>
      arr(0) = b
      arr(1) = a
      arr
    case _ => arr

  }
  swapElems(Array(1,2,3,4))
  swapElems(Array())


//  4. Add a case class Multiple that is a subclass of the Item class. For example,
//  Multiple(10, Article("Blackwell Toaster", 29.95)) describes ten toasters. Of course,
//  you should be able to handle any items, such as bundles or multiples, in
//  the second argument. Extend the price function to handle this new case.


  sealed abstract class Item
  case class Bundle(desc: String, disc: Double, items: Item*) extends Item
  case class Article(desc: String, price: Double) extends Item
  case class Multiple(amount: Int, item: Item) extends Item

  def price(item: Item): Double = item match {
      case Article(_, p) => p
      case Bundle(_, discount, items @ _*) => items.map(price).sum - discount
      case Multiple(amount, items) => amount * price(items)
      case _ => 0.0
    }
val test =  Bundle("Sale", 15.0,
  Article("New York Times", 2.50),
  Multiple(10, Article("Blackwell Toaster", 29.95))
)

price(test)
//  5. One can use lists to model trees that store values only in the leaves. For
//  example, the list ((3 8) 2 (5)) describes the tree
//  •
//  /|\
//  • 2 •
//  / \ |
//  3 8 5
//  However, some of the list elements are numbers and others are lists. In Scala,
//  you cannot have heterogeneous lists, so you have to use a List[Any]. Write a
//    leafSum function to compute the sum of all elements in the leaves, using pattern
//    matching to differentiate between numbers and lists.

  def leafSum(tree: List[Any]): Int = {
    def helper(sub: Any): Int = sub match {
      case single: Int => single
      case x :: xy => helper(x) + helper(xy)
      case _ => 0
    }
    tree.foldLeft(0)(_ + helper(_))
  }

  leafSum(List(List(3,8),2, List(5)))


//  6. A better way of modeling such trees is with case classes. Let’s start with binary
//  trees.
//  sealed abstract class BinaryTree
//  case class Leaf(value: Int) extends BinaryTree
//  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
//  Write a function to compute the sum of all elements in the leaves.
    sealed abstract class BinaryTree
    case class Leaf1(value: Int) extends BinaryTree
    case class Node1(left: BinaryTree, right: BinaryTree) extends BinaryTree

  def leafSumWClasses(bt: BinaryTree): Int = bt match {
    case leaf: Leaf1 => leaf.value
    case left Node1 right => leafSumWClasses(left) + leafSumWClasses(right)

  }
  leafSumWClasses(List(List(3,8),2, List(5)))


//  7. Extend the tree in the preceding exercise so that each node can have an arbitrary number of children,
  //  and reimplement the leafSum function. The tree in
//  Exercise 5 should be expressible as
//    Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
//

    case class Leaf(value: Int) extends BinaryTree
    case class Node(children: BinaryTree*) extends BinaryTree

    def leafSum3(bt: BinaryTree): Int = bt match {
      case Leaf(x) => x
        //case leaf: Leaf => leaf.value isn't ideal, case classes prefer above
      case Node(x @ _*) => x.foldLeft(0)((acc, item) => acc + leafSum3(item))
        //(x @ _* => binds x to the variable [Seq] of args
        //@ => works as an unapply for var length args
        //case class prefers
        // case Node(x) => x.foldLeft(0)((acc, item) => acc + leafsum3(item) => expecting single child rather than children
    }
  leafSum3(Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5))))


//  8. Extend the tree in the preceding exercise so that each nonleaf node stores
//    an operator in addition to the child nodes. Then write a function eval that
//    computes the value. For example, the tree
//    +
//      /|\
//  * 2 -
//    / \ |
//  3 8 5
//  has value (3 × 8) + 2 + (–5) = 21.
//  Pay attention to the unary minus.

    sealed abstract class ExpressionTree{}
    case class Leaf2(value: Int) extends ExpressionTree
    class Operator private(val identity: Int, operator: (Int, Int) => Int) {

    def apply(a: Int, b: Int): Int = {
      operator(a, b)
    }
  }
  object Operator {

    val Add = new Operator(0, _ + _)
    val Subtract = new Operator(0, _ - _)
    val Multiply = new Operator(1, _ * _)
  }
    case class Node2(operator: Operator, children: ExpressionTree*) extends ExpressionTree


    def eval(bt: ExpressionTree): Int = bt match {
      case Leaf2(x) => x
      case Node2(operator, x @_*) => x.foldLeft(operator.identity) {
        (acc, item) => operator(acc, eval(item))
        //item is expression tree => also must be evaluated
        //
      }
    }

    eval(Node2(Operator.Add,Leaf2(3), Leaf2(8), Leaf2(2), Node2(Operator.Add,Leaf2(5))))


//  9. Write a function that computes the sum of the non-None values in a
//    List[Option[Int]]. Don’t use a match statement.
  def nonNoneCompute(lst: List[Option[Int]]): Int = {
  lst.flatten.sum
}

  nonNoneCompute(List(Some(1),Some(3),Some(0)))
//  10. Write a function that composes two functions of type Double => Option[Double],
//  yielding another function of the same type. The composition should yield
//  None if either function does. For example,
//  def f(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
//  def g(x: Double) = if (x >= 0) Some(sqrt(x)) else None
//  val h = compose(g, f) // h(x) should be g(f(x))
//  Then h(2) is Some(1), and h(1) and h(0) are None.
}
object Agg extends App {
  //count all of the characters in a set of strings
  val sando = List("Tomato", "Avocado", "Lettuce")
  val acc: ((Int, String), String) => (Int, String) = (acc, ingredient) => (acc._1 + ingredient.length, acc._2 + ingredient)
  val len = sando.aggregate((0,""))(acc, (a,b) => (a._1 - b._1, a._2 + b._2))
  len
  //tuple1 = calc count
  //tuple2 = concat all str



}