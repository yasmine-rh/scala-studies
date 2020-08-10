package rockthejvm.lectures.part2oop

object Objects extends App {
  //class-level functionality

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY = Doesn't have 'static'
  // we use obj instead,

  object Person { // type + its only instance
    //"static" or class-level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")

  }

  class Person (val name: String){
    //instance-level functionality

  }
  //COMPANIONS obj Person and class Person


  //objs can be defined similar to classes, but do not take params
  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object is singleton instance by definition:
  val mary = Person // instance of the Person type
  val john = Person

  val mary2 = new Person("mary") // instance of the Person type
  val john2 = new Person("john")

  println(mary == john) //point to the same instance, so it's true
  println(mary2 == john2) //not == bc new instances of class Person

  val bobbie = Person(mary2, john2)

  //Scala Applications
  //only a scala obj with a very important method
  //def main(args: Array[String]): Unit

  /* Takeaways

  scala doesn't have "static" methods/values

  SCALA OBJECTS
   - are their own class
   - are the only instance
   - singleton pattern in one line!

   SCALA COMPANIONS
   - can access each other's private members
   - scala is more oo than java!

   SCALA APPLICATIONS
   def main(args: Array[String]): Unit
   object MyApp extends AppType {}


   */

}
