package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object CurriedFunctionWithDefaultArguments extends App {

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

 /** It is possible for us to specify default values for input arguments
  *  with curried function as well. The date and the ticker have default values */

  def getStockPriceDetails(date: String = "11-06-2020") (ticker: String = "GOOG")( priceType: String):
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

    (record.date, record.ticker, price)
  }
  /** Here's how we invoke a curried function with default values */
  println(getStockPriceDetails()()(priceType = "high"))
  println("-----------------------------------------")
  println(getStockPriceDetails()(ticker = "MSFT")(priceType = "high"))
  println("-----------------------------------------")
  print(getStockPriceDetails(date = "12-06-2020")()(priceType = "high"))

}
