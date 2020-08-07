package rockthejvm.lectures

object DefaultArgs extends App {
  @scala.annotation.tailrec
  def trFact(n: Int, acc: Int): Int = {
    if (n <= 1) acc
    else trFact(n-1, n * acc)
  }
  val fact10 = trFact(10,1)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080) : Unit = println("saving picture")
  savePicture(width = 800)

  /*
  1. Pass in every leading arg
  2. Name the args
   */
  savePicture(height = 600, width = 800, format = "bmp")

  /*
  when 99% of the time when we call a fxn with the same paraps
  naming params

   */
}
