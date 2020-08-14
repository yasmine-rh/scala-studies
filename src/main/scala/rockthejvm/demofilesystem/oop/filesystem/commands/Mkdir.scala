package rockthejvm.demofilesystem.oop.filesystem.commands

import rockthejvm.demofilesystem.oop.filesystem.files.{DirEntry, Directory}
import rockthejvm.demofilesystem.oop.filesystem.filesystem.State

class Mkdir (name: String) extends Command {
  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage(("Entry " + name + " already exists!"))
    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not contain separators!")
    } else if (checkIllegal(name)){
      state.setMessage(name + ": illegal entry name!")
    }else {
      doMkdir(state,name)
    }
  }

  def checkIllegal(str: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, str: String): State = {

    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if(path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }
    }

    def findDescendant(path: List[String]): Directory = ???

    val wd = state.wd

    // 1. all the directories in the full path

    val allDirsInPath = wd.getAllFoldersInPath

    // 2. create new dir entry in the wd

    val newDir = Directory.empty(wd.path, name)

    // 3. update whole dir structure starting from root
    // - dir structure is immutable

    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

    // 4. find new wd instance given wd's full path in the NEW DIR structure

    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)




  }
}
