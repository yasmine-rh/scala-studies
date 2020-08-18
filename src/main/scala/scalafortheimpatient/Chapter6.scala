package scalafortheimpatient

class Chapter6 {}
//  1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and
//  milesToKilometers.
 class UnitConversions{


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
object Conversions extends UnitConversions {

  override def inchesToCentimeters(inches: Int): Double = super.inchesToCentimeters(inches)

  override def gallonsToLiters(gallons: Int): Double = super.gallonsToLiters(gallons)

  override def milesToKilometers(miles: Int): Double = super.milesToKilometers(miles)


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
//val newPoint = Point(2,3)
//  val plot1 = new Point(1,3)
//  5. Write a Scala application, using the App trait, that prints the command-line
//  arguments in reverse order, separated by spaces. For example, scala Reverse
//    Hello World should print World Hello.
  object ScalaApplication extends App {
    def reversing(args: String): String = {
      args.split(" ").reverse.foldLeft("")((a, b) => a + " " + b)

//      String.join(" ", args.split(" ").reverse: _*)
      //_* look this up
      //fold fxn is combinator takes starting val based on fxn and combines that val w current element in obj
      //List(elem(Cons(elem(Cons(elem(
      //std ml
    }
  println(ScalaApplication.reversing("tomato soup"))
  }

//  6. Write an enumeration describing the four playing card suits so that the toString
//    method returns ♣, ♦, ♥, or ♠.
object PlayingCards extends Enumeration {
  val clover = Value("♣")
  val diamond = Value("♦")
  val heart = Value("♥")
  val spade = Value("♠")
}

//  7. Implement a function that checks whether a card suit value from the preceding
//    exercise is red.
object CheckCards {
  def isItRed(card: PlayingCards.Value): Boolean = {
    card == PlayingCards.diamond || card == PlayingCards.heart
  }
}
//  8. Write an enumeration describing the eight corners of the RGB color cube. As
//  IDs, use the color values (for example, 0xff0000 for Red).

object CornersRGB extends Enumeration {
  type CornersRBG = Value
  val black = Value(0x0)
  val red = Value(0xff0000)
  val blue = Value(0x0000ff)
  val magenta = Value(0xff00ff)
  val green = Value(0x00ff00)
  val cyan = Value(0x0ffff)
  val yellow = Value(0xffff00)
  val white = Value(0xffffff)

}

