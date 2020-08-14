package scalafortheimpatient

class Chapter6 {
//  1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and
//  milesToKilometers.
 class UnitConversions{
  val centimeters: Double = Conversions.inchesToCentimeters(???)
  val gallons: Double = Conversions.gallonsToLiters(???)
  val kilometers: Double = Conversions.milesToKilometers(???)

}
object Conversions extends UnitConversions {


  def inchesToCentimeters(inches: Int): Double = {
    inches * 2.54
  }

  def gallonsToLiters(gallons: Int): Double = {
    gallons * 3.78541
  }

  def milesToKilometers(miles: Int): Double = {
    miles * 1.60934
  }

}
//  2. The preceding problem wasn’t very object-oriented. Provide a general superclass UnitConversion and define objects
//  InchesToCentimeters, GallonsToLiters, and MilesToKilometers that extend it.

//  3. Define an Origin object that extends java.awt.Point. Why is this not actually a
//    good idea? (Have a close look at the methods of the Point class.)
  object Origin extends java.awt.Point {
  //this isn't a good idea because Point creates
}
//  4. Define a Point class with a companion object so that you can construct Point
//    instances as Point(3, 4), without using new.
  class Point (x: Int, y: Int){
}
  object Point {
    def apply(x: Int, y: Int) = new Point(x,y)
  }
  val plot1 = Point(1,3)
//  5. Write a Scala application, using the App trait, that prints the command-line
//  arguments in reverse order, separated by spaces. For example, scala Reverse
//    Hello World should print World Hello.
class ScalaApplication(args: String){
}
  object ScalaApplication extends App {
    def reversing(args: String): Unit = {
      val newStr = new ScalaApplication(args)
      println(newStr.toString.reverse)
    }


  }

//  6. Write an enumeration describing the four playing card suits so that the toString
//    method returns ♣, ♦, ♥, or ♠.
object PlayingCards extends Enumeration {
  val ♣, ♦, ♥,♠ = values

}

//  7. Implement a function that checks whether a card suit value from the preceding
//    exercise is red.
//  8. Write an enumeration describing the eight corners of the RGB color cube. As
//  IDs, use the color values (for example, 0xff0000 for Red).
}
