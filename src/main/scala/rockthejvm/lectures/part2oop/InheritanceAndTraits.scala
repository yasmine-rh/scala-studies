package rockthejvm.lectures.part2oop

object InheritanceAndTraits extends App  {

  //scala has single class inheritance

  class Animal {
    private def eat(): Unit = println("nomnomnom")
    //private is only accessible from this class
    def eat2(): Unit = println("nomnomnom")
    protected def eat3(): Unit = println("nomnomnom")
    //protected marks method only usable within class and its subclasses
  }


  //single class inheritance
  class Cat extends Animal {
    //cat is subclass of animal
    //animal is superclass of cat

    def crunch(): Unit = {
      eat3()
      println("crunch crunch")
    }
  }
  val cat = new Cat
  cat.eat2()//cat.eat isn't accessible bc private
  cat.crunch()

  //CONSTRUCTORS
  class Person(name: String, age: Int)

}
