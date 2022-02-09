package com.pluralsight.methodsandfunctions.ExceptionAndMissingValues

import scala.io.{BufferedSource, Source}
import scala.util.{Failure, Success, Try}

object TrySuccessfulFailure extends App {

  /** Try: Represent a computation that may either result in
   *  an exception or successfully compute a value */

 /** In this method getLineFromFile, which accepts a file name as an input
  *  we have it return a buffered source wrapped */
  def getLinesFromFile(filename: String): Try[BufferedSource] = {
    Try(Source.fromFile(filename))
  }

  val trySourcePath: Try[BufferedSource] =
    getLinesFromFile("src/main/resources/dividendStockss.csv")

  trySourcePath match {
    case Success(sourcePath) => sourcePath.getLines.toList.foreach(println)
    case Failure(exception) => println(exception.getMessage)
  }

}
