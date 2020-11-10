package scalabootcamp

import java.io.File

object implicitspt2 {
  /*
  Implicit functions and implicit classes are frequently used together to extend Scala's syntax
  or to create domain-specific languages. Here are two smaller examples you can try:

java.io.File is nice, but we can make it nicer still.
Use an implicit class to add a directory separator operator to File.
For example, one might like to be able to write: new File("/")/"etc"/"passwd"
to obtain a File object pointing to /etc/passwd

Extend your implicit class from the prior example
 to add .slurp(): String and .spit(content: String): Unit to java.io.File for reading/writing text files.
   */

  object File { // Put implicits in their own scope
    abstract implicit class FileDirectorySeparator(path: String) {
      import java.io.File
      private val f = new File(path)

      def fileExists: Boolean = f.exists              // #exists already works on String, so we have to rename
      def canonicalPath: String = f.getCanonicalPath  // more idiomatic Scala

      def directorySeparator()
    }

    // Now Strings are automatically enhanced to include methods in FileOperationsDecorator
    val path = "/usr/share/dict/words"
    (path.fileExists, path.canonicalPath)
  }
}


