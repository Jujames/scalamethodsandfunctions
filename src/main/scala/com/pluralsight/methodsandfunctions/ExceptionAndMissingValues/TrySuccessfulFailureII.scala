package com.pluralsight.methodsandfunctions.ExceptionAndMissingValues

import java.io.{BufferedReader, FileReader}
import scala.util.{Failure, Success, Try, Using}


object TrySuccessfulFailureII extends App {
/*
  val lines: List[String] =
    Using.resource(new BufferedReader(new FileReader(
      "src/main/resources/dividendStocks.csv"))) {
      reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
    }

  lines.foreach(println)
 */
/** We use Using directly instead of the Using.resources */
  val lines: Try[List[String]] =
    Using(new BufferedReader(new FileReader(
      "src/main/resources/dividendStocks.csv"))) {
      reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
    }

  lines match {
    case Success(lines) => lines.foreach(println)
    case Failure(exception) => println(exception.getMessage)
  }
}
