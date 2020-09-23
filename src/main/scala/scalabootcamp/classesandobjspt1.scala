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
  class Pet(val petName: String, val breed: AnimalBreed.Value, val age: Int)  {
    def equals[T](param: T): T = param


    override def hashCode(): Int = ???

    def toString[T](param: T): String = param match {
      case  _ : String => param.asInstanceOf[String]
      case _ => param.asInstanceOf[String]
    }
    //TODO convert entire object to str


    //TODO: write enum for breed types so that the match case statements are less likely to automatically go to "_" case

    def speak(breed: AnimalBreed.Value): Unit =
//      case _ => println(AnimalBreed)
        //or
     breed.toString()
//      case fish => println(AnimalBreed.fish)
//      case cow => println(AnimalBreed.cow)
//      case sheep => println(AnimalBreed.sheep)

        /* or
        case
         */
        //use .toString here

    }

}
