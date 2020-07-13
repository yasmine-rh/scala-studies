package scalafortheimpatient

class Chapter1 extends App {
  // 1.1 The Scala Interpreter
 println(8 * 5 + 2)
  //should return 42

  // 1.2 Declaring Values and Variables

  // 1.3 Commonly used types

  //Scala has seven numeric types: Byte, Char, Short, Int, Long,
  //Float, and Double, and a Boolean type which are actually classes

  //1.7 Scaladoc
  //• A method tagged as implicit is an automatic conversion. For example, the
  //BigInt object has conversions from int and long to BigInt that are automatically
  //called when needed


 /*  Exercises
  1. In the Scala REPL, type 3. followed by the Tab key. What methods can be
    applied?
  2. In the Scala REPL, compute the square root of 3, and then square that value.
    By how much does the result differ from 3? (Hint: The res variables are your
    friend.)
  3. Are the res variables val or var?
  4. Scala lets you multiply a string with a number—try out "crazy" * 3 in the REPL.
    What does this operation do? Where can you find it in Scaladoc?
  5. What does 10 max 2 mean? In which class is the max method defined?
  6. Using BigInt, compute 21024.
  7. What do you need to import so that you can get a random prime as
  probablePrime(100, Random), without any qualifiers before probablePrime and Random?
    8. One way to create random file or directory names is to produce a random
  BigInt and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul".
  Poke around Scaladoc to find a way of doing this in Scala.
  9. How do you get the first character of a string in Scala? The last character?
  10. What do the take, drop, takeRight, and dropRight string functions do? What
//    advantage or disadvantage do they have over using substring? */
//  1.  (#:: ... .xml)
//  2.  sqrt(3)
//  res1: Double = 1.7320508075688772
//  scala.math.pow(res1,2)
//  res2: Double = 2.9999999999999996
//  3. The res variables are vals because they do not change, they are not transformed, rather the
//    new result is another res
//  4. "crazy" * 3
//  res22: String = "crazycrazycrazy"
//  This operation
//  5. Max finds largest element in list and is defined in the RichInt class
//  6. import scala.math._
//  7.import util.Random
//  8.
//  9. Use charAt(whichever_index_number)
//  10. take => returns n characters provided
//        drop => drops first n characters
//        takeRight => returns last n characters from right
//          dropRight => drops last n characters from right
}
