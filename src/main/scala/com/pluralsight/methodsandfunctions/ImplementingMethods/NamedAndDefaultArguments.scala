package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object NamedAndDefaultArguments extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  def getStockPriceDetails(date: String, ticker: String, priceType: String):
  (String, String, Float) = {

    println(s"Accessing records for $date")
    var filterRecords = records.filter(_.date == date)

    println(s"Accessing records for $ticker")
    filterRecords = filterRecords.filter(_.ticker == ticker)

    val record = filterRecords(0)

    println(s"Accessing price type $priceType")
    val price = priceType match {
      case "open" => record.open
      case "close" => record.close
      case "high" => record.high
      case "low" => record.low
    }

    /** Returns a Tuple */
    (record.date, record.ticker, price)
  }

   /** Positional argument values are
    *  assigned based on position or
    *  order in which arguments are specified */
  println(getStockPriceDetails("12-06-2020", "BNS", "open"))

}
