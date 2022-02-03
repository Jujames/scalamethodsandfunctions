package com.pluralsight.methodsandfunctions.ImplementingFunctions

object Placeholders extends App {

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73, 1400.00)

  /** Prints all in the list */
  googStockPrices.foreach((price: Double) => println(price))


  /*    /** Filter method */
  val googStockPricesGreaterThan1400 =
    googStockPrices.filter((price: Double) => price > 1400)
  */
  /** Function literal can be written in a shorter form if the type of the input can
   * be inferred, this is called TARGET TYPING */
  val googStockPricesGreaterThan1400 =
    googStockPrices.filter(price => price > 1400)

  val googStockPriceLessThan1400 =
    googStockPrices.filter(price => price < 1400)

  /** If you don't want to explicity specify the input argument
   * you can use the WILDCARD OR UNDERSCORE _ symbol which can hold one or more
   * parameters to be passed int a function object */
  val googStockPriceGreaterThan1300 =
    googStockPrices.filter(_ > 1300)

  val stockTickerInLowercase = List("goog", "ps", "tsla", "aapl", "msft")

  val stockTicker = stockTickerInLowercase.map(_.toUpperCase)


  println("------------------------")

  println(googStockPricesGreaterThan1400)
  println("------------------------")
  println(googStockPriceLessThan1400)
  println("------------------------")
  println(googStockPriceGreaterThan1300)
  println("------------------------")
  println(stockTicker)
}
