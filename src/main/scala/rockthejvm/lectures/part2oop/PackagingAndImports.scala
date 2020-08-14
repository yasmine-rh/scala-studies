package rockthejvm.lectures.part2oop

import rockthejvm.playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

//package members are accessible by their simple name
//  val writer = new Writer("Daniel", "RockTheJVM", 2018)
  //idk why this doesn't work

  //import the package
  val princess = new Princess //rockthejvm.playground.Cinderella fully qualified name

  //packages are in hierarchy
  //matching folder structure

  //package object
sayHello()
  println(SPEED_OF_LIGHT)

  //imports
val prince = new PrinceCharming

  //1. Use fully-qualified name
val d = new Date
  //2. Use aliasing
val sqlDate = new SqlDate(2018,5,3)

  //default imports
  //java.lang - String, Object, Exception
  //scala - INt, Nothing, Function
  //scala.Predef - println




}
