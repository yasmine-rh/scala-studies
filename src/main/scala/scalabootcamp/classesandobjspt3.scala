package scalabootcamp

import scalabootcamp.classesandobjspt3.Animals.Vocalization

object classesandobjspt3 extends App {

  object Loggers {
    trait Logger {
      def error(t: Throwable, message: String): Unit = ???
      def warn(message: String): Unit = ???
      def info(message: String): Unit = ???
    }

    trait StdoutLogger extends Logger {
      override def error(t: Throwable, message: String) = {
        import java.io._

        val stringWriter = new StringWriter()
        t.printStackTrace(new PrintWriter(stringWriter))
        val stackTrace = stringWriter.toString.split("\n").take(7).mkString("", "\n", "\n at ....")

        println(s"[ERROR] $message\n$stackTrace")
      }

      override def warn(message: String) = println(s"[WARN] $message")

      override def info(message: String) = println(s"[INFO] $message")
    }

    // Let's write a meta-meta-logger!!!
    trait Slf4JLogger extends Logger {
      // Do slf4j things here...
      override def error(t: Throwable, message: String) = ???
      override def warn(message: String) = ???
      override def info(message: String) = ???
    }
  }
  object Animals {
    trait Vocalization {
      def logSpokenWord(word: String): Unit = ???
    }
    trait Locomotion {
      def movement(actions: String): Unit = ???
    }
    abstract class Animal extends Loggers.Logger with Vocalization {
      def logSpokenWord(word: String)
      def movement(action: String): Unit = ???
    }

    class HappyCat() extends Animal with Loggers.StdoutLogger with Vocalization {
      override def logSpokenWord(word: String) = info(s"purrrrr purrrrrrr $word pufffrrr")
      override def movement(action: String): Unit = info(s"${action+"ing"}")
    }

    class SleepyCat() extends Animal with Loggers.StdoutLogger with Vocalization {
      override def logSpokenWord(word: String) = warn("zzzzZZZZZzzzZZZ")
      override def movement(action: String): Unit = info(s"${action+"ing"}")
    }

    class GrumpyCat() extends Animal with Loggers.StdoutLogger with Vocalization {
      override def logSpokenWord(word: String) = error(new IllegalStateException(word),
        s"The worst part of my Monday....  is hearing you complain about your $word!")
    }

    val cuteKitty = new Animals.GrumpyCat()
  }

  Animals.cuteKitty.logSpokenWord("happiness")

  class BarkyDog() extends Animals.Animal with Vocalization {
    override def logSpokenWord(word: String) = warn("GgrrgrrrrrgggrraaAARRRfFF!")
    override def movement(action: String): Unit = info(s"${action+"ing"}")
  }

  val fido = new BarkyDog() with Loggers.StdoutLogger with Vocalization
  // fido: BarkyDog with Loggers.StdoutLogger = repl.Session$App$$anon$1@3dcb08fc

  fido.logSpokenWord("Niiiiice doggy")
  // [WARN] GgrrgrrrrrgggrraaAARRRfFF!


}
