package scalabootcamp

object classesandobjspt1 extends App {
/*
Make a Scala Pet class. In addition to implementing equals, hashCode, and toString,
 add a speak method that returns an appropriate vocalization for your pet.
 */
object AnimalBreed extends Enumeration {
  val cat = Value("meow")
  val dog = Value("woof")
  val fish = Value("bloop")
  val cow = Value("moo")
  val sheep = Value("baa")
}
//enums usually used for restricting JSON input in our production code
//turn the enum to a map

//the enum should

  object AnimalSound extends Enumeration {
    val cat = Value("meow")
    val dog = Value("woof")
    val fish = Value("bloop")
    val cow = Value("moo")
    val sheep = Value("baa")
  }
 // AnimalBreed("meow") this only works w RallyEnumerations => AnimalBreed.cat
  //useful if already receiving string ie JSON

  //apply() takes type of Enum and attempts to match it to possible values -- if it succeeds creates new instance,
  // if it fails throws an error
  //maps handier for default values

  //can call a match on AnimalSound and give it a default case

  class Pet(val petName: String, val breed: AnimalBreed.Value, val age: Int)  {
    def equals[T](param: T): T = param


    override def hashCode: Int = petName.map(a => a.charValue()).sum + breed.toString.map(a => a.charValue()).sum
      +  (7 * age)

     def hashCode2: Int = petName.map(a => a.charValue()).foldLeft(0)((a, b) => a - b) + breed.toString.map(a => a.charValue()).foldLeft(0)((a,b)=> a - b)
    +  (7 * age)

    def hashCode3: Pet = new Pet(petName.map(a => a.charValue()) , breed , (7 * age))



    var tina = new Pet("tina", AnimalBreed.cat, 7)
    tina.hashCode3

    //hashcode should

    //if pet1 == pet2 hashcoded values should also be the same

    //if (Pet1.equals(Pet2))
    //hashcodes should be eq however eq is defined
    //if equals



    def toString[T](param: T): String =
      Pet.this.asInstanceOf[String]

    def toString2[T](param: T): String =
      petName + breed + age.toString
    // in the enum Value is just an obj in
    //Enum.Value  = a type


    def speak(): Unit = println(breed.toString)

    }

  val freddie = new Pet("Freddie", AnimalBreed.cat, 5)
  freddie.toString()
  freddie.speak()
  freddie.hashCode()


}
