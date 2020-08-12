package rockthejvm.lectures

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println(
        "Computing factorial of " + n +
          " - first need factorial of" + (n - 1)
      )

      val result = n + factorial(n - 1)
      println("Computed factorial of " + n)
      result

    }

  }
  println(factorial(10))
  println(factorial(3))

  def anotherFactorial(n: Int): BigInt = {
    @scala.annotation.tailrec
    def factHelper(x: Int, acc: BigInt): BigInt = {
      if (x <= 1) acc
      else factHelper(x -1, x * acc) // tailrec
      //use tail recursive call as the LAST expression

    }
    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10,1)
   = factHelper(9, 10 *1)
   = factHelper(8, 9 * 10 * 1)
   = factHelper(7 * 8 * 9 *10 * 1
     ...
   = factHelper(1, 2 * 3 * 4 ...* 10 * 1)
   */

  anotherFactorial(5000)

  //when you need loops, use tailrecursion

  /*
  1. concat string using tailrec
  2. isprime() tailrec
  3. fibonacci w tailrec
   */

  @scala.annotation.tailrec
  def concatTailRec(str: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else concatTailRec(str, n-1, str + acc)
  }
  println(concatTailRec("hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @scala.annotation.tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      //isStillPrime holds intermediate result
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n/2, isStillPrime = true)
  }
  println(isPrime(2003))
  println(isPrime(629))


  def fib(n: Int): Int = {
    def fibTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if(i > n) last
      else fibTailRec(i + 1, last + nextToLast, last)
    if (n < 2) 1
      else fibTailRec(3,1,1)
    }
    //use two acc because fib calls n-1, n-2
    //rule of thumb is that you need to have however many accumulators for each recursive call that you make
    //ie fibonacci makes 2 recursive calls each time so it needs 2 accumulators
n
  }
  println(fib(8))
}
