package rockthejvm.lectures.part2oop



object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")
  person.greet()
  val counter = new Counter()
  counter.inc.print()
  counter.inc.inc.inc.print()
  counter.inc(10).print()
}
  //constructor
  class Person(var name: String, var age: Int) { // constructor
    //a class organizes data and behavior that is code
    //instantiation - concrete implementations in code
    //class params and class field that you can access are different
    //to access must use val/var

    //body
    val x = 2
    println(1 + 3)

    //method
    def greet(name: String): Unit = println(s"${this.name} says Hi, $name")

    //overloading
    def greet(): Unit = println(s"Hi, I am $name")

    //multiple constructors
    def this(name: String) = this(name, 0)

    def this() = this("John Doe")

    /*
  Novel and Writer

  Writer: first name, surname, year of birth
  - method "fullName" = return first and last

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new Novel
   */

    class Writer(val firstName: String, val surName: String, val year: Int) {

      def fullName(firstName: String, surName: String): String = {
        (firstName + " " + surName)
      }
    }

    class Novel(val name: String, val year: Int, val author: Writer) {

      def authorAge: Int = year - author.year

      def writtenBy(author: Writer): Unit = println(author)

      def copy(newYear: Int): Novel = new Novel(name, newYear, author)
    }
    val author = new Writer("Charles", "Dickens", 1812)
    val novel = new Novel("Great Expectations", 1861, author)
    val imposter = new Writer("Charles", "Dickens", 1812)
    println(novel.authorAge)
    println(novel.writtenBy(imposter))
    /*
  Counter class
  -receives an int val
  - method current count
  -method to increment/decrement => new Counter
  -overload inc/dec to receive an amount
   */
  }

  class Counter(val value: Int = 0) {
   def inc: Counter =  {
     println("incrementing")
     new Counter(value + 1)
   } //immutablity
   def dec: Counter = {
     println("decrementing")
     new Counter(value - 1)
   }

    def inc(n: Int): Counter = {
     if (n <= 0) this
      else inc.inc(n-1)
    }
    def dec(n: Int): Counter =
      if (n <= 0) this
      else dec.dec(n-1)

      def print(): Unit = println(value)


  }
/*
Takeaways:

defining classes
instantiating
parameters vs fields
defining methods
calling methods
- syntax allowed for parameter-less fxns
 */








