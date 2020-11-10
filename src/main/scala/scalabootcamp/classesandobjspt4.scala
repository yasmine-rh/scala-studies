package scalabootcamp

object classesandobjspt4 {

  object Animalia {
    sealed trait Animal {
      val speciesName: String
    }

    case class Dog(name: String, breed: String, barkFrequencyPeaksHz : Set[Int]) extends Animal { override val speciesName="Canis Familiaris" }

    case class Cat(name: String, breed: String, meowFrequencyMillis: Int, sleepFrequencyMillis: Int) extends Animal { override val speciesName="Felis catus" }

    case class Parrot(name: String, favoritePhrases: Set[String]) extends Animal { override val speciesName="Psittaciformes" }

    def getBreed(a: Animal): Option[String] = a match {
      case Dog(_, breed, _) => Some(breed)
      case Cat(_, breed, _, _) => Some(breed)
      case p: Parrot => None

    }
    // warning: classes-and-objects-pt4.md:136:47: match may not be exhaustive.
    // It would fail on the following input: Cat(_, _, _, _)
    //     def getBreed(a: Animal): Option[String] = a match {
  }

}
