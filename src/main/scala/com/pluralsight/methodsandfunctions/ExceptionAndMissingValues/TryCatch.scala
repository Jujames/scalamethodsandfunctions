package com.pluralsight.methodsandfunctions.ExceptionAndMissingValues

import java.io.{FileNotFoundException, IOException}
import scala.io.Source

object TryCatch extends App {

try {
  val sourcePath = Source.fromFile("src/main/resources/dividendStockss.csv")

  println("Reading file completed")

  val lines = sourcePath.getLines.toList
  lines.foreach(println)

  println("Displaying line completed")

} catch {
  case ex:FileNotFoundException => {
    println("File not found")
  }

  case ex:IOException => {
    println("Input/Output Exception")
  }
}
println("-------------------------------End of code reached")

}
