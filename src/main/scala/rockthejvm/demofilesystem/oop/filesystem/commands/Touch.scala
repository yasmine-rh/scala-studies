package rockthejvm.demofilesystem.oop.filesystem.commands


import rockthejvm.demofilesystem.oop.filesystem.files.{DirEntry, File}
import rockthejvm.demofilesystem.oop.filesystem.filesystem.State



class Touch(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)
}
