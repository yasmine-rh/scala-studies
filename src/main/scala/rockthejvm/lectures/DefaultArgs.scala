package rockthejvm.lectures

object DefaultArgs extends App {
  @scala.annotation.tailrec
  def trFact(n: Int, acc: Int): Int = {
    if (n <= 1) acc
    else trFact(n-1, n * acc)
  }
}
