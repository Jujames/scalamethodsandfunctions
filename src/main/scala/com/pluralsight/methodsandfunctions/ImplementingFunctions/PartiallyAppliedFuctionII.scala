package com.pluralsight.methodsandfunctions.ImplementingFunctions

object PartiallyAppliedFuctionII extends App {

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73, 1400.00)

  def checkPriceGreaterThan1400(price: Double): Boolean = price >= 1400

  /** Same method using partially Applied function:
   * The "_" is a placeholder for an entire parameter list.
   * This is a partially applied function,where you do not supply
   * all of the arguments the function needs, you specify either
   * some or none of the argument. The UnderScore is the placeholder
   * fro the entire list  * */

  /** using partially Applied function: */

  val googStockPricesGreaterThan1400 =
    googStockPrices.filter(checkPriceGreaterThan1400 _)
  println(googStockPricesGreaterThan1400)
}
