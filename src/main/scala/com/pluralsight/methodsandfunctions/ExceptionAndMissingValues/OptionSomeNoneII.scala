package com.pluralsight.methodsandfunctions.ExceptionAndMissingValues

import com.pluralsight.methodsandfunctions.ExceptionAndMissingValues.OptionSomeNone.convertToFloat

object OptionSomeNoneII extends App {

  def convertToFloat(someString: String): Option[Float] = {
    try {
      Some(someString.toFloat)
    } catch {
      case e: NumberFormatException => None
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf",
    "1393.33", "1404.31", "1419.82", "1429.73")

  val googStockPricesFloat = googStockPrices.map(convertToFloat)

  for (optionPrice <- googStockPricesFloat) {
    optionPrice match {
      case Some(price) => println(price)
      case None => println("Skipping over None")
    }
  }
  println("----------------------------------")

  /** You can also use getOrElse */
  for (optionPrice <- googStockPricesFloat) {
    println(optionPrice.getOrElse(-1))
  }
   println("------------------------------")
  /** To be more concise we can use a map and getOrElse */
  println(googStockPricesFloat.map(_.getOrElse(0)))
  println("------------------------------")

  /** The advantage of using the option some or none idiom value is
   * that there are Scala library methods which understand this idiom
   * and do the right things. such as the flatMap */

  /** FlatMap() combinator automatically just maps the valid values
   *  so the result can be used directly in mathematical expression. */
  val googStockPriceFloat = googStockPrices.flatMap(convertToFloat)

  println(googStockPricesFloat)
  println("Average price " + (googStockPriceFloat.sum / googStockPricesFloat.size))
}
