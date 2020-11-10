package scalabootcamp

object implicitspt4 extends App {

  trait Pet {
    val name: String
  }

  case class Dog(override val name: String, barkVolumeDb: Double) extends Pet

  implicit val myDog = Dog("Cocoa", 120)

  println(myDog)

  def printPetName(implicit pet: Pet) = println(pet.name)
  printPetName(myDog)

  printPetName   // myDog was injected automatically because she's the only Pet in scope!  🤯
  // Cocoa

  trait DatabaseConnection {
    def ask(query: String): String
  }

  class FakeDatabase extends DatabaseConnection {
    override def ask(query: String) = query + ": fake results"
  }

  class AlexaOnMyDesk(connectionString: String) extends DatabaseConnection {
    override def ask(query: String) = query + ":\n>>>> Error: 🤮\n>>>> Error: Customers not found.\n>>>> Cause: Those people didn't sit still.\n>>>> Cause: They all moved around starting Web sites, one after another after ano..."
  }

  class DatabaseModule(environment: String, etcetcetcetera: String) {
    val connection = environment match {
      case "scalatest" => new FakeDatabase
      case "laptop" => new AlexaOnMyDesk("get connection string from etcetcetcetera")
      // ...
    }
  }

  class CustomerService {
    def getAll(implicit db: DatabaseModule): String = {
      db.connection.ask("Hey Alexa: Find me all the customers from before the .com crash")
    }
  }

  class Application(implicit db: DatabaseModule) {
    val customers = new CustomerService

    def partyLikeIts1999 = println(customers.getAll)
  }

  implicit val database = new DatabaseModule("laptop", "etcetcetcetera")

  val app = new Application

  app.partyLikeIts1999


  object DatabaseConfig {
    trait Environment
    class TestEnv extends Environment
    class ProdEnv extends Environment

    trait DB[E <: Environment] {
      def ask(q: String): String
    }

    class TestDb[E <: Environment] extends DB[E] {
      override def ask(query: String): String = query + ": fake results"
    }

    class Hal[E <: Environment] extends DB[E] {
      override def ask(query: String) = "I'm sorry Dave, I just can't do that."
    }

    implicit val stub = new TestDb[TestEnv]
    implicit val hal = new Hal[ProdEnv]
  }


  /*
  Notice that in this instance two implicit database vals are in scope: both stub and hal. How might we write a query
   method so that depending on the current environment in scope, the correct database
   will automatically be chosen? Modify the following example to make it behave as expected:
   */
  // Given:
  import DatabaseConfig._
  implicit val env = new ProdEnv

  // Change this line so that
  def query(q: String): String = hal.ask(q)

  // this line automatically picks up the implicit Hal instance
  query("Open the cargo-bay doors")

}
