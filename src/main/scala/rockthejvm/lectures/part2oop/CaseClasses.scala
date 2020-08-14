package rockthejvm.lectures.part2oop

object CaseClasses extends App {
  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  //1. class params are fields

  val jim = new Person ("Jim", 34)
  println(jim.name)

  //2. sensible toString
  //println(instance) = println(instance).toString

  println(jim.toString)
  println(jim) //samesies

  //3. equals and hashCode implemented out of the box

  val jim2 = new Person("Jim", 34)

  println(jim == jim2) //returns true bc case class but wouldn't be for class

  // 4. CCs have handy copy methods
  val jim3 = jim.copy(age = 45) //this updates the age, keeps the name
  println(jim3)

  //5. CCs have companion obj
  val thePerson = Person //compiler automatically creates comp obj
  val mary = Person("Mary", 23) //delegates to person's apply method

  //6. CCs are serializable
  //esp useful w Akka framework

  //7. CCs have extractor patterns = CCs can be used in pattern matching

  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  } //acts like cc but obj

  /*
  Expand MyList to use cc and co
   */

  /*
  Quick lightweight data structure with little boilerplate
  companions already implemented
  sensible equals, hashcode, strings
  autopromoted params to fields
  cloning
   */
}
