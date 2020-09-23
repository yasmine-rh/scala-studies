package scalabootcamp

object fxnsreturningfxns extends App {

 /* Experiment with functions returning functions as a substitute for domain objects.
  When would you want to use this technique? When not?*/

   class LegalName(surName: String) {
    def name(firstName: String) = s"$surName, $firstName"
  }
  val initiateIdentifier = new LegalName("Smith")
  initiateIdentifier.name("Joe")

  class fullLegalName(surName: String) {
    def name2(firstName: String, middleName: Option[String]): String =  middleName match {
      case Some(_) => s"$surName, $firstName ${middleName.get}"
      case None => s"$surName, $firstName"
    }
  }
  val initiateIdentifier2 = new fullLegalName("Smith")
  initiateIdentifier2.name2("Joe", None)

  val initiateIdentifier3 = new fullLegalName("Tomato")
  initiateIdentifier3.name2("Roasted", Some("Cherry"))
}
