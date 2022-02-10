package com.pluralsight.methodsandfunctions.ExceptionAndMissingValues

object OptionSomeNone extends App {

  /** An Option can be an instance of the Some class or the None class -
   *  Some and None are both children of Option */

  /* def convertToFloat(someString: String): Any = { */
  def convertToFloat(someString: String): Option[Float]= {
    try {
      //val floatVal = someString.toFloat
      Some(someString.toFloat)
      // floatVal
    } catch {
   /* case e: NumberFormatException => null */
      case e: NumberFormatException => None
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf",
   "1393.33", "1404.31", "1419.82", "1429.73")

  println(googStockPrices.map(convertToFloat))

}
