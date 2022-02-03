package com.pluralsight.methodsandfunctions.ImplementingFunctions

object PartiallyAppliedFunctionIV extends App{

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73, 1400.00)

  def checkPriceInRange(price: Double, lower: Double, upper: Double): Boolean =
    price >= lower && price <= upper

  val googStockPricesInRangeFunction = checkPriceInRange _

  val googStockPriceInRange =
    googStockPrices.filter(price => googStockPricesInRangeFunction(price, 1390, 1410))

  println(googStockPriceInRange)

}
