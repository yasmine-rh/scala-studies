package rockthejvm.lectures.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = new Tuple2(2, "Hello Scala") // Tuple2[Int, String] = (Int, String)
  val aTuple2 =  Tuple2(2, "Hello Scala") //samesies bc has apply method

  println(aTuple._1) //2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  //Maps - keys -> values

  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim" -> 555), ("Daniel" -> 789), ("JIM", 90000)).withDefaultValue(-1)
  // a -> b is sugar for tuple(a,b)
  println(phoneBook)

  //map operations
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim")) //returns value assoc w key
  println(phoneBook("Marv"))

  //add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  //fxnals on maps
  //map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.filterKeys(_.startsWith("J")))
  println(phoneBook.filterKeys(x => x.startsWith("J"))) //same as above

  //mapValues
  println(phoneBook.mapValues(number => number * 10))
  println(phoneBook.mapValues(number => "0245-" + number))

  //conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary","Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
  takeaways
  tuples
  maps
  functionals
  - filterKeys
  - mapValues
  - map, filter, flatMap (on pairings)

   */

  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900
    !!! careful with mapping keys
    2. Overly simplified social network based on maps
    Person = String
     - add a person to the network
     - remove
     - friend (mutual)
     - unfriend (mutual)

     - number of friends of a given person
     - person w most friends
     - how many ppl w no friends
     - if there is a social connection btwn 2 ppl (direct or not)
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network:  Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {

    @scala.annotation.tailrec
    def removeAuxiliary(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAuxiliary(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAuxiliary(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty,"Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(network, "Bob", "Mary"), "Mary", "Bob")
  println(remove(friend(network, "Bob","Mary"), "Bob"))

  // Jim, Bob, Mary
  val people =  add(add(add(empty,"Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Jim", "Bob")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size


  println(nFriends(testNet, "Bob"))


  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(network))


  def nPeopleWithNoFriends(network: Map[String, Set[String]]) : Int =
    network.filterKeys(k => network(k).isEmpty).size
  println(nPeopleWithNoFriends(network))

  def nPeopleWithNoFriends2(network: Map[String, Set[String]]) : Int =
    network.count(pair => pair._2.isEmpty)
  println(nPeopleWithNoFriends2(network))

  def nPeopleWithNoFriends3(network: Map[String, Set[String]]) : Int =
    network.count(_._2.isEmpty)
  println(nPeopleWithNoFriends3(network))


  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @scala.annotation.tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      //can i find target in discovered ppl having considered consideredPpl already
      if (discoveredPeople.isEmpty) false
      else {
         val person = discoveredPeople.head
         if (person == target) true
         else if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
         else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet,"Mary", "Jim"))
  println(socialConnection(testNet,"Mary", "Bob"))


}
