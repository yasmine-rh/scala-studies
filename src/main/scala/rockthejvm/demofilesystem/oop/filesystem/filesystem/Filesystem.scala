package rockthejvm.demofilesystem.oop.filesystem.filesystem

import java.util.Scanner

import rockthejvm.demofilesystem.oop.filesystem.commands.Command
import rockthejvm.demofilesystem.oop.filesystem.files.Directory

object Filesystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while(true) {
    state.show()
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }
}
