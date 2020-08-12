package rockthejvm.lectures.part2oop

object AbstractDataTypes extends App {
  //abstract members
  //class which contain unimplemented or abstract fields or methods

  abstract class Animal {
    //abstract class cannot be instantiated, are made to be implemented pater
    val creatureType: String = "wild"
    def eat(): Unit
  }
  class Dog extends Animal {

    override val creatureType: String = "Canine"
    def eat(): Unit = println("crunch, crunch")
  }

  //traits
  //created using trait kw
  trait Carnivore {
    def eat(animal: Animal): Unit
    //traits by default have abstract fields and methods
    //unlike abstract clasess they can be inherited
    val preferredMeal: String = "fresh meat"

  }
 trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {

    override val creatureType: String = "croc"
    def eat(): Unit = "nomnomnomnom"
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract classes
  //abstract classes can have abstract and non abstract types but so do traits
  //traits cannot have constructor params!!!!
  //you can only extend one class but can mix in multiple traits
  //scala has single class inheritance
  //we choose a trait vs an abstract class if it describes a certain behavior
  /*
  1. Traits do not have constructor parameters
  2. multiple traits may be inherited by the same class
  3. traits = behavior, abstract class = "thing

   */

  /*
  Scala's type Hierarchy
  scala.Any => scala.AnyRef
  ||              ||
 scala.AnyVal     String..List,Set
  ||                            ||
  Int, Unit, Bool, Float      scala.Null
                          \/
                        scala.Nothing

   */

}
