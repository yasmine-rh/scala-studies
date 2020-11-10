package scalabootcamp

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.util.{Success,Failure}
import scala.io.Source
import java.io._

object introtofutures  extends App {

  /*
  As illustrated above, the main way Scala programs process Future results is to process
  those results in a callback and allow the current thread to process to completion.
  Why would that be?
Change getInfoToDisplay so that getProduct1234Info throws an exception
and examine what happens. Does getProduct1234Picture still execute? Why or why not?
Try the same with getProduct1234Picture and see what happens. Can you explain the program's behavior?
Here's a Scala newbie mistake with Futures; what's not great about rewriting the example above this way?

   */

//  val getInfoToDisplay = for {
//    productInfo <- Future {
//      (1234, "Product description")
//    }
//
//      picture <-  Future {
//        val b = new ByteArrayOutputStream
//        val p = new PrintStream(b)
//        p.print("a beautiful image")
//        b.toByteArray
//      }
//  } yield {
//
//    val (productId, description) = productInfo
//    (productId, description, picture)
//  }





  val getProduct1234Info: Future[(Int, Int)] = Future { throw new RuntimeException }
  // getProduct1234Info: Future[(Int, String)] = Future(Success((1234,Product description)))

  val getProduct1234Picture = Future[Array[Byte]] {
    println("sandwich")
    throw new RuntimeException

  }


  // getProduct1234Picture: Future[Array[Byte]] = Future(Success([B@7b92d22))

  // Combine both futures' results
  getProduct1234Info.flatMap { case (productId, description) =>
    getProduct1234Picture.map { picture =>
      (productId, description, picture)
    }
  }

//  getInfoToDisplay.onComplete {
//    case Success(info) => println(info)
//    case Failure(exception) => exception.printStackTrace()
//  }



  val getInfoToDisplay = for {
    productInfo <- getProduct1234Info
    picture <- getProduct1234Picture
  } yield {
    val (productId, description) = productInfo
    (productId, description, picture)
  }

  //this whole thing runs itself as a future
  //for comp acts like 3rd thread/future, does comp and self returns



  getInfoToDisplay.onComplete {
    case Success(info) => println(info)
    case Failure(exception) => exception.printStackTrace()
  }

    /*
    future runs on its own thread  as soon as its declared
    future can return at any point, but unless it hits a for comp or something like that

    program counter = thing  in cpu that tracks where you are in the code

     */
}
