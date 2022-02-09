package com.pluralsight.methodsandfunctions.ExceptionAndMissingValues

import java.io.{FileNotFoundException, IOException}
import scala.io.{BufferedSource, Source}

object TryCatchFinallyII extends App {

  /** Try and catch and finally with return results from method */
  def getLineFromFile(filename: String): List[String] = {

    /** I initialize the buffered source toread the contents of the file
     *  within the try catch blocks */
    var sourcePath: BufferedSource = null

    try {
      sourcePath = Source.fromFile(filename)
      println("Reading file completed")

      sourcePath.getLines.toList
    } catch {
      case ex: FileNotFoundException => {
        println("File not found")
        List()
      }
      case ex: IOException => {
        println("Input/Output Exception")
        List()
      }

    /** In the finally block, which contains code that would be
     *  executed, whether or not an exception was thrown  */
    } finally {
      println("Close file if it has been opened")
      if (sourcePath != null) {
        println("Closing file")
        sourcePath.close()
      }
      List("avoid", "result", "expressions", "from", "the", "finally", "block")
    }
  }

  val lines = getLineFromFile("src/main/resources/dividendStocks.csv")

  println("----------------------Displaying lines")
  lines.foreach(println)

}
