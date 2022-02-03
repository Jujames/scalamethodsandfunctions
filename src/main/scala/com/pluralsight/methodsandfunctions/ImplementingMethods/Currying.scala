package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object Currying extends App {

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

  def getPrice(date: String, ticker: String, priceType: String): Float = {

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

  println(getPrice("12-06-2020", "GOOG", "open"))
  println(getPrice("12-06-2020", "MSFT", "close"))


}
