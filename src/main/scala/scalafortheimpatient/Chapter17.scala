package scalafortheimpatient

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

class Chapter17 extends App {

//  1. Consider the expression
//  for (n1 <- Future { Thread.sleep(1000) ; 2 }
//    n2 <- Future { Thread.sleep(1000); 40 })
//  println(n1 + n2)
//  How is the expression translated to map and flatMap calls? Are the two futures
//  executed concurrently or one after the other? In which thread does the call
//    to println occur?

  val f1 = Future {
  Thread.sleep(1000)
  2
  }
  val f2 = Future {
    Thread.sleep(1000)
    40
  }

  f1.flatMap(n1 => f2.map(n2 => {
    println(n1 + n2)
    n1 + n2
  }))
  //the expression f1 iz executed first, f2 is only executed after f1 has finished successfully.
  //println executes in f2's thread

//    2. Write a function doInOrder that, given two functions f: T => Future[U] and g: U
//  => Future[V], produces a function T => Future[U] that, for a given t, eventually
//  yields g(f(t)).

def doInOrder[T,U,V](f: T => Future[U], g: U => Future[V]): T => Future[V] = {
  (t: T) => f(t).flatMap((u => g(u)))
}
//  doInOrder(f1, f2)

  //  3. Repeat the preceding exercise for any sequence of functions of type T =>
//    Future[T].

  def doInOrder2[T](f: Seq[T => Future[T]]): T => Future[T] = { t =>
    f match {
      case head :: Nil => head(t)
      case head :: tail => head(t).flatMap(doInOrder2(tail)(_))
    }
  }

  val f1 = (value: Int) => Future {
    value + 1
  }
  val f2 = (value: Int) => Future {
    value + 2
  }
  val f3 = (value: Int) => Future {
    value + 3
  }

  doInOrder2(Seq(f1, f2, f3))

//  4. Write a function doTogether that, given two functions f: T => Future[U] and
//    g: U => Future[V], produces a function T => Future[(U, V)], running the two
//  computations in parallel and, for a given t, eventually yielding (f(t), g(t)).

def doTogether[T,U,V](f: T => Future[U], g: T => Future[V]): T => Future[(U,V)] = {
t => {
  val ft = f(t)
  val gt = g(t)
  for (t1 <- ft; t2 <- gt) yield (t1, t2)
}
}
//  5. Write a function that receives a sequence of futures and returns a future that
//  eventually yields a sequence of all results.
def seqFutures[T] (futures: Seq[Future[T]]): Future[Seq[T]] = {
  val first = Future {
    List[T]()
  }
  futures.foldRight(first)((future, res) => res.flatMap(result => future.map(r => r :: result)))
}
seqFutures(List(1))
//  6. Write a method
//    Future[T] repeat(action: => T, until: T => Boolean)
//  that asynchronously repeats the action until it produces a value that is
//    accepted by the until predicate, which should also run asynchronously. Test
//  with a function that reads a password from the console, and a function that
//    simulates a validity check by sleeping for a second and then checking
//  that the password is "secret". Hint: Use recursion.


//  7. Write a program that counts the prime numbers between 1 and n, as reported
//    by BigInt.isProbablePrime. Divide the interval into p parts, where p is the number
//  of available processors. Count the primes in each part in concurrent futures
//  and combine the results.

def primeNums()
//  8. Write a program that asks the user for a URL, reads the web page at that URL,
//  and displays all the hyperlinks. Use a separate Future for each of these three
//    steps.


//  9. Write a program that asks the user for a URL, reads the web page at that URL,
//  finds all the hyperlinks, visits each of them concurrently, and locates the Server
//    HTTP header for each of them. Finally, print a table of which servers were
//  found how often. The futures that visit each page should return the header.

  def URL(link: String): Future[]{
  ???
  }

//  10. Change the preceding exercise where the futures that visit each header update
//  a shared Java ConcurrentHashMap or Scala TrieMap. This isn’t as easy as it sounds.
//  A threadsafe data structure is safe in the sense that you cannot corrupt its
//    implementation, but you have to make sure that sequences of reads and
//  updates are atomic.


//  11. Using futures, run four tasks that each sleep for ten seconds and then print
//  the current time. If you have a reasonably modern computer, it is very likely
//    that it reports four available processors to the JVM, and the futures should
//    all complete at around the same time. Now repeat with forty tasks. What
//  happens? Why? Replace the execution context with a cached thread pool.
//  What happens now? (Be careful to define the futures after replacing the implicit
//  execution context.)


//  12. Write a method that, given a URL, locates all hyperlinks, makes a promise
//  for each of them, starts a task in which it will eventually fulfill all promises,
//  and returns a sequence of futures for the promises. Why would it not be a
//    good idea to return a sequence of promises?


//  13. Use a promise for implementing cancellation. Given a range of big integers,
//  split the range into subranges that you concurrently search for palindromic
//  primes. When such a prime is found, set it as the value of the future. All tasks
//    should periodically check whether the promise is completed, in which case
//  they should terminate.


}
