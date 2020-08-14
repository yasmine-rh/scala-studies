package rockthejvm.lectures.part4pm

import rockthejvm.exercises.{Cons, Empty, MyList}


object AllThePatterns extends App {
    //1. constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A Singleton obj"
  }

  //2 match anything
  //2.1 wildcard

  val matchAnything = x match {
    case _ =>
  }

  //2.2
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) =>
  }

  val nestedTuple = (1, (2,3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2,v)) =>
  }

  // PMs can be Nested!

  // 4 - case classes - constructor pattern
  //PMS can be nested w case classes as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }

  // 5 - list patterns

  val aStdList = List(1,2,3,42)
  val standardListMatching = aStdList match {
    case List(1, _, _,_) => //extractor - advanced concept
    case List(1, _*) => //list of arbitrary length
    case 1 :: List(_) => //infix pattern
    case List(1,2,3) :+ 42 => //infix pattern
  }

  //6 type specifiers
//  val unknown: Any = 2
//  val unknownMatch = unknown match {
//    case list: List[Int] => //explicit type specifier
//    case _ =>
//  }

  // name binding
//  val nameBindingMatch = aList match {
//    case nonEmptyList @ Cons(_,_) =>  //name binding use the name later(here)
//    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
//  }

  //8 multipatterns
//  val multipattern = aList match {
//    case empty | Cons(0, _) => // compound pattern (multi-pattern
//  }

//  //9 - if guards
//  val secondElementSpecial = aList match {
//    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
//  }

  //that's all folks!

  /*
  Question

   */
//  val numbers = List(1,2,3)
//  val numbersMatch = numbers match {
//    case listOfStrings: List[String] => "a list of strings"
//    case listOfNumbers: List[Int] => "a list of numbers"
//    case _ => ""
//  }
//println(numbersMatch) // case matches against list of strings
  //JVM trick QUESTION

}
