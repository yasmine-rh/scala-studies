package rockthejvm.demofilesystem.oop.filesystem.commands

import rockthejvm.demofilesystem.oop.filesystem.filesystem.State

class Pwd extends Command {
  override def apply(state: State): State =
    state.setMessage(state.wd.path)
}
