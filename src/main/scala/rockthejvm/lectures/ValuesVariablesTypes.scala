package rockthejvm.lectures

object ValuesVariablesTypes extends App {

  val x: Int = 42

  // cannot reassign vals, as they are immutable
  //  val x = 42 val types are optional, as the compiler is able to infer type

  println(x)

  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 1234535454534435436L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables - mutable
  var aVariable: Int = 4
  aVariable = 3 // side effects
  //programs w/o side effects are easier to understand, but it's inevitable that there will be side effects







}
