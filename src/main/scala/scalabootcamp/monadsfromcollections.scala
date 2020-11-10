package scalabootcamp

object monadsfromcollections extends App {

def doSomething(string: String) = Seq(string.hashCode)
def doSomethingElse(string: String)= Seq(string.replace('a','e'))

  val transformVal = Seq("tomato", "tarantula", "tomatillo")
  val listOption = List(None, None, Some(3), Some(4), Some(5))
  val collection = (1 to 10)
  collection.flatMap(x => Vector(x * 5))
  collection.flatMap(_ => Vector())
  collection.flatMap(_.toString)
  transformVal.flatMap(_.toUpperCase())
  //try to increase output with the list of ints

  transformVal.flatMap(_.concat(""))
  transformVal.flatMap(x => (x.foldLeft("")((a, b) => a + b)))
  listOption.flatMap(x => x)
  listOption.flatMap(x => x.map(a => a * 2)) //typically used in conjunction w map like ex

  //flatten and flatMap have flatten method defined on nested collections
  List(Set(1,3,4), Set(1,2,3)).flatten
  List(Set(1,3,4), Set(1,2,3)).flatMap(x => x.map(_ * 2))


  /*
  function calls future then calls another future

  see SponsorshipController:  def getAffiliationInternal for ex

  ///starlog

  //Action.async almost eq to Secure/Insec (build upon A.a)  action async but handles some extra starlog stuff
  //insec for internal endpts




  - when running
   */

}


