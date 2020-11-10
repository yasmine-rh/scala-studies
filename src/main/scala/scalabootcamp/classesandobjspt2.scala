package scalabootcamp

import scalabootcamp.classesandobjspt1.AnimalBreed
import scalabootcamp.classesandobjspt1.AnimalBreed.Value
import scalabootcamp.classesandobjspt2.Pet

object classesandobjspt2 extends App {

  object AnimalBreed extends Enumeration {
    val cat = Value("meow")
    val dog = Value("woof")
    val fish = Value("bloop")
    val cow = Value("moo")
    val sheep = Value("baa")
  }


  class Pet(val petName: String, val breed: AnimalBreed.Value, val age: Int)  {
    def equals[T](param: T): T = param

    override def hashCode: Int = petName.map(a => a.charValue()).sum + breed.toString.map(a => a.charValue()).sum
    +  (7 * age)


    def toString[T](param: T): String =
      Pet.this.asInstanceOf[String]


    def speak(): Unit = println(breed.toString)

    object Pet {
      def apply(): Pet = new Pet(petName, breed, age)

      override def hashCode: Int = petName.map(a => a.charValue()).sum + breed.toString.map(a => a.charValue()).sum
      +  (7 * age)


      def toString[T](param: T): String =
        Pet.this.asInstanceOf[String]

      def speak(): Unit = println(breed.toString)
    }
  }



  val freddie = new Pet("Freddie", AnimalBreed.cat, 5)
  freddie.toString()
  freddie.speak()
  freddie.hashCode()
}
