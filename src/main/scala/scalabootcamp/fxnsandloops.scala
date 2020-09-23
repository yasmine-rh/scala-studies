package scalabootcamp

object fxnsandloops extends App {

  def encode(str: String): String = {
    (str.toUpperCase().split("").map(a => a.hashCode+ 1).map(b => b.toChar).mkString)
  }
  encode("abc")

  def encode2(str: String): String = {
    (str.toUpperCase().map(a => (a.hashCode + 1).toChar).mkString(""))
  }
  encode2("abc")

  //update and remove split

  def decode(str: String): String = {
    str.toLowerCase().split("").map(a => (a.hashCode - 1).toChar).mkString("")
  }
  decode("BCD")

  //what are limitations?
}
