package com.pluralsight.methodsandfunctions.ExceptionAndMissingValues

object EitherRightLeft extends App {

  /** Either-Right-Left is exactly analogous to Option-Some-None except
   *  that with this you can pass back information on why a certain computation failed */

  def convertToFloat(someString: String): Either[String, Float] = {
    try{
      Right(someString.toFloat)
    } catch {
      case e: NumberFormatException =>
       Left("There was an error parsing the float: " + someString)
    }
  }

  val googStockPrices = List("1367.36", "asdf", "1360.66", "1394.20",
    "1393.33", "1404.31", "1419.82", "1429.73")

  // println(googStockPrices.map(convertToFloat))
  val googStockPricesFloat = googStockPrices.map(convertToFloat)

  for (optionPrice <- googStockPricesFloat) {
    optionPrice match {
      case Right(price) => println(price)
      case Left(message) => println(message)
    }
  }

}
