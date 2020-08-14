package rockthejvm.lectures.part2oop

object Generics extends App {
  
  class MyList[A] {

    // use the type A inside class definition
    //generic class

    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Dog = Animal
    B = Animal
     */

  }
  
  class MyMap[Key, Value]
    
    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]
  
  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  //does a List[Cat] extend List[Animal]
  //yes, this is covariance

  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Animal]
  //animalList.add(new Dog)??? does this work?? => We return a list of animals
  //this pollutes list of cat, so no

  //No - INVARIANCE

  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //Hell no  - CONTRAVARIANCE

//  class ContravariantList[-A]
//  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  //BOUNDED TYPES

  //allow you to use diff

//  class Cage[A <: Animal](animal: A)
//  //only accepts subtypes of animal
//  val cage = new Cage(new Dog)

//  class Car
//  val newCage = new Cage(new Car) this doesn't work bc cage only accepts supertype of Animal

  //bounded types solve a variance problem





}
