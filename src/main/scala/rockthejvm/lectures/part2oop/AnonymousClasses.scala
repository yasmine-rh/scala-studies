package rockthejvm.lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat(): Unit
  }

  //anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat(): Unit = println("ahahaahahhaha")
  }

  /*equivalent to

  class AnonymousClasses$$anon$1 extends Animal {
   override def eat(): Unit = println("ahahaahahhaha")
   }
   */

  class Person(name: String) {

    def sayHi(): Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim"){
    override def sayHi(): Unit = println(s"Hi my name is Jim, how can I be of service?")
  }


  println(funnyAnimal.getClass)

  /*
  takeaways
  we can instantiate types and override fields or methods on teh sport

  RULES:
  pass in required constructor args if needed
  implement all abstract fields/methods
  -works for traits and classes(abstract or not)
   */

  /*
  1. Generic trait MyPredicate[-T] with a lil method test(T) => Boolean //contravariant
  2. Generic trait MyTransformer[-A, B] with a method transform(A) => B //contravariant
  3. MyList:
    -map(transformer) => MyList
    - filter(predicate) => MyList
    - flatMap(transformer from A to MyList[B) => MyList[B]

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyTransformer[String, Int]

    [1,2,3].map(n * 2) = [2,4,6]
    [1,2,3,4].filter(n%2) = [2,4]
    [1,2,3].flatMap(n => [n, n+1] => [1,2,2,3,3,4]
   */
}
