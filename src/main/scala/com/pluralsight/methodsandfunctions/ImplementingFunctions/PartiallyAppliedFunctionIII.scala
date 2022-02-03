package com.pluralsight.methodsandfunctions.ImplementingFunctions

object PartiallyAppliedFunctionIII extends App {

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73, 1400.00)

  def checkPriceGreaterThan1400(price: Double): Boolean = price >= 1400

  /** Partially applied function on a variable */
  val checkPricesGreaterThan1400Function = checkPriceGreaterThan1400 _

  val googStockPricesGreaterThan1400 =
    googStockPrices.filter(checkPricesGreaterThan1400Function)

  println(googStockPricesGreaterThan1400)
}
