package rockthejvm.demofilesystem.oop.filesystem.commands

import rockthejvm.demofilesystem.oop.filesystem.files.{DirEntry, Directory}
import rockthejvm.demofilesystem.oop.filesystem.filesystem.State

class Mkdir (name: String) extends CreateEntry(name) {

  override def createSpecificEntry(
    state: State
  ): DirEntry =
    Directory.empty(state.wd.path, name)

}
