package scalabootcamp

object implicitsPt1 extends App {

  /*Implicit conversions can be used to mimic dynamic typing found in other languages.
  Since it's dangerous to implement implicit conversions directly between built-in types (e.g.: from Int to Float),
  how might one achieve a similar effect using traits and/or case classes as an intermediate form?
  Implement dynamic type behavior for Int, String, and Double using one or more intermediate types.
   */

  object FileImplicits {
    import scala.language.implicitConversions
    import java.io.File

    implicit def string2File(path: String): File = new File(path)
    implicit def file2String(f: File): String = f.getCanonicalPath
  }

  import FileImplicits._

  object PasswordSecret{

    implicit def string2Hash(password: String): Int = password.hashCode()
    implicit def hash2String(hash: Int): String = hash.toString
    implicit def hash2Double(hash: Int): Double = hash.toDouble
    implicit def string2Double(password: String): Double = password.hashCode().toDouble
  }

  import PasswordSecret._

}
