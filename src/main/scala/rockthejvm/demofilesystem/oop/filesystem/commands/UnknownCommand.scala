package rockthejvm.demofilesystem.oop.filesystem.commands

import rockthejvm.demofilesystem.oop.filesystem.filesystem.State

class UnknownCommand extends Command {

  override def apply(state: State): State =
    state.setMessage("Command not found!")

}
