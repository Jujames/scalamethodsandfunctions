package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object CurryingUsingPlaceHolders extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/newStockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  /** A curried function has multiple arguments lists - this is equivalent
   *  to multiple function invocation back to back. The first function
   *  accepts 2 arguments, the second function accepts one. */

  /** Changed to a method using curried Functions */
  def getPrice(date: String, ticker: String)( priceType: String): Float = {

    /** first filter stock records by date */
    val recordsByDate = records.filter(_.date == date)

    /** then filter the stock records by ticker */
    val recordsByTicker = recordsByDate.filter(_.ticker == ticker)

    /** then perform a pattern match on the price type */
    val price = priceType match {
      case "open" => recordsByTicker(0).open
      case "close" => recordsByTicker(0).close
      case "high" => recordsByTicker(0).high
      case "low" => recordsByTicker(0).low
    }

    price
  }
  /** Curried function using the placeholder notation,
   *  the placeholder notation allows us to use the curried function as
   *  partially applied function */
  val getPriceForGoog = getPrice("12-06-2020", "GOOG") _

  println("-------------------GOOG")
  println("Open: " + getPriceForGoog("open"))
  println("Close: " + getPriceForGoog("close"))
  println("High: " + getPriceForGoog("high"))
  println("low: " + getPriceForGoog("low"))

  val getPriceForMsft = getPrice("12-06-2020", "MSFT") _

  println("--------------------MSFT")
  println("Open: " + getPriceForMsft("open"))
  println("Close: " + getPriceForMsft("close"))
  println("High: " + getPriceForMsft("high"))
  println("Low: " + getPriceForMsft("low"))
}
