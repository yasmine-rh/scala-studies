package rockthejvm.lectures.part3fp

object MapFlatMapFilterFor extends App {
  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_+1))
  println(list.map(_+" is a number"))

  //filter
  println(list.filter(_%2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x+ 1)
  println(list.flatMap(toPair))


  //print all combinations btwn 2 lists
  val numbers = List(1,2,3,4)
  val characters = List('a','b','c','d')
  val colors = List("black", "white")
  //List("a1","a2".. "b2", "c3", "d4")


  //"iterations"
  val combinations = numbers.flatMap(n => characters.map(c => "" + c + n))
  println(combinations)

  val combinations2 = numbers.flatMap(n => characters.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations2)

  /*
    val combinations2 = numbers.filter(_% 2 ==0) flatMap(n => characters.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations2)

  THIS IS LIKE FOR COMP BELOW
   */

  //foreach
  list.foreach(println) //print on each line

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- characters
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  //syntax overload

  list.map { x =>
    x * 2
  }

  /*
  1. MyList supports for comprehensions
  map(f: A => B) MyList[B]
  filter(p: A => Boolean) => MyList[A]
  flatMap(f: A => MyList[B]) => MyList[B]
  2. A small collection of at most ONE element - Maybe[+T]
    - map, flatMap, filter
   */







}
