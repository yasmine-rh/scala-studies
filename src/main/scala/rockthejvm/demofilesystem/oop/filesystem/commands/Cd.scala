package rockthejvm.demofilesystem.oop.filesystem.commands

import rockthejvm.demofilesystem.oop.filesystem.files.{DirEntry, Directory}
import rockthejvm.demofilesystem.oop.filesystem.filesystem.State

import scala.annotation.tailrec

class Cd(dir: String) extends Command {

  override def apply(state: State): State = {
    //find root
    val root = state.root
    val wd = state.wd
    //find abs path
   val absolutePath =
     if(dir.startsWith(Directory.SEPARATOR)) dir
     else if (wd.isRoot) wd.path + dir
     else wd.path + Directory.SEPARATOR + dir

    //find the dir

    val destinationDirectory = doFindEntry(root, absolutePath)


    //change the state

    if (destinationDirectory == null || !destinationDirectory.isDirectory)
      state.setMessage(dir + ": no such directory")
    else
      State(root, destinationDirectory.asDirectory)




  }




   def doFindEntry(root: Directory, path: String): DirEntry = {
     @tailrec
     def findEntryHelper(currentDirectory: Directory, path: List[String]): DirEntry =
       if (path.isEmpty || path.head.isEmpty) currentDirectory
       else if (path.tail.isEmpty) currentDirectory.findEntry(path.head)
       else {
         val nextDir = currentDirectory.findEntry(path.head)
         if (nextDir == null || !nextDir.isDirectory) null
         else findEntryHelper(nextDir.asDirectory, path.tail)
       }

  @tailrec
   def collapseRelativeTokens(path: List[String], result: List[String]): List[String] = {
    if (path.isEmpty) result
    else if (".".equals(path.head)) collapseRelativeTokens(path.tail, result)
    else if ("..".equals(path.head)) {
      if (result.isEmpty) null
      else collapseRelativeTokens(path.tail, result.init)
    } else collapseRelativeTokens(path.tail, result :+ path.head)
  }
     //1. tokens
     val tokens: List[String] = path.substring(1).split(Directory.SEPARATOR).toList

   val newTokens = collapseRelativeTokens(tokens, List())
     if (newTokens == null) null
     //1.5 eliminate/collapse relative tokens

     /*
    ["a", "."] => ["a"]
    ["a", "b", ".", "."] => ["a", "b"]

    /a/../ => ["a", ".."] => []
    /a/b/.. => ["a", "b", ".."] => ["a"]

   */
     //2. navigate to correct entry
     findEntryHelper(root, tokens)

   }
}
