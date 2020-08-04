package rockthejvm.lectures

object Functions extends App {

  def aFunction(a: String, b : Int): String = {
    a + " " + b
  }
  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction())


  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
  println(aRepeatedFunction("hello", 3))

  // When you need to loop, choose recursion over for/while/etc looping

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  /*
  1. A greeting function (name, age) =>
  "Hi my $name is and I am $age years old"
  2. Factorial function 1 * 2 * 3 * n
  3. Fibonacci function
  4. Test if a number is prime
   */

  def greeting(name: String, age: Int): String = {
    s"Hi my name is $name  and I am $age years old"

  }
  println(greeting("me", 5))

  def factorial(n:Int): Int ={
    if(n <= 0) 1
    else (n * factorial( n - 1))
  }
  println(factorial(4))

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }
  println(fibonacci(8))

  def isPrime(n:Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    }
    isPrimeUntil(n/2)
  }
  println(isPrime(37))
  println(isPrime(2003))

}
