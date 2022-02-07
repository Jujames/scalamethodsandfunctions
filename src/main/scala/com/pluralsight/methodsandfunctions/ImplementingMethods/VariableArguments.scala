package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object VariableArguments extends App {

  def readFinanceData(): Vector[StockRecord] = {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      rows = line.split(",").map(_.trim)
    } yield StockRecord(rows(0), rows(1).toFloat,
      rows(2).toFloat, rows(3).toFloat,
      rows(4).toFloat, rows(5))
  }

  private val data = readFinanceData()

/** To get the flexibility and to specify one or more tickers: We specified that
    ticker: is of type String followed by an *(asterisk). This basically means
    that I can invoke this function with zero or more ticker: values */

  def getRecords(tickers: String*):Vector[(String, String, Float)] = {
    println("What is ticker type: " + tickers.getClass)   // To understand the class associated with the ticker object
    for (ticker <- tickers) println(ticker)

    val filterRecords = data.filter(record => tickers.contains(record.ticker))
    filterRecords.map(record => (record.date, record.ticker, record.close))
  }

/** Because of the asterisk getRecords accepts a variable number of arguments,
 *  which means you can invoke this method by specifying multiple
 *  ticker values, separated by a comma.  */

 /* val records = getRecords("MSFT", "GOOG", "TM") */

/** When a method accepts variable number of arguments,
 *  you can invoke it with no arguments at all */

  val records = getRecords()
  records.foreach(println)

}
