package rockthejvm.lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name($nickname", favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply() : String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala: String = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes("Inception"))//equivalent
  //infix notation = operator notation (syntactic sugar)

  //"operators" in Scala
  val tom = new Person ("Tom", "Fight Club")
  println(mary hangoutWith(tom))
  println(mary hangoutWith tom)

  println(mary + tom)


  println(1+2)
  println(1.+(2))

  //ALL OPERATORS ARE METHODS!
  //Akka actors have ! ? ask/tell patterns btwn async actors

  //prefix notation
  val x = -1
  val y = 1.unary_- //samesies but only works with a few operators = + ! ~
  println(!mary)
  println(mary.unary_!)

  //postfix notation -- not super common, only can be used when method doesn't have params
  println(mary.isAlive)
  println(mary isAlive)

  //apply - whenever
  println(mary.apply())
  println(mary())//equivalent


  /*
  1. Overload the + operator
  mary + "the rockstar" => new Person "Mary (the rockstar)"

  2, Add an age to the Person class
   - add a unary + operator with the age +1
   +mary => mary with the age incrementer

  3. Add a "learns" method in the person class => "Mary learns Scala"
    - add a learnsScala method, calls learns method with "Scala"
   - use it in the postfix notation

   4. Overload the apply method
   marry.apply(2) => "Mary watched inception 2 times"

   */

  println((mary + "the Rockstar")())
  println((mary + "the Rockstar)").apply()) //samesies
  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))

  /*Takeaways:
  method notation - methods with only one param can be called with obj - method - param

  unary operators
  - prefix notation

  postfix notation
   */





}
