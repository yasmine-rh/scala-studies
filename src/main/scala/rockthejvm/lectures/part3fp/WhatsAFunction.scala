package rockthejvm.lectures.part3fp

object WhatsAFunction extends App {

  //DREAM: use and work w fxns as first-class elems
  //problem: oop world
val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2

  }

  println(doubler(2))

  //function types = Function1[A, B]

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  //Function types Function2[A,B,R] === (A,B) => R

  //  ALL SCALA FXNS ARE OBJS

  /*
  1. define a fxn which takes 2 strings and concat
  2. transform the MyPredicate and MyTransformer into fxn types
  3. define a fxn which takes an int and returns another fxn which takes an int and returns
  an int
      - what's the type of this fxn
      - how to implement?
   */

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("Hello", "Scala"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) //curried fxn

  /*
  Takeaways
  We want to work w fxns
  - pass fxns as params
  -use fxns as vals

  Proble: Scala works on top of JVM
  - designed for Java
  - firstclass elms: objs(instances of classes)

  Solution: ALL Scala fxns are objs!
   - fxn traits, up to 22 params
   - syntactic sugar fxn types
   ex:
   trait Function1[-A, B] {
    def apply(element: A): B
    }
   */


}

trait MyFunction[A, B] {
  def apply(elem: A): B

}
