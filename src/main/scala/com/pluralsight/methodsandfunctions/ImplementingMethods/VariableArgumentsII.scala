package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object VariableArgumentsII extends App {

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

/* Updated code to be more concise, it still accepts a variable number of Strings */
  def getRecords(tickers: String*):Vector[(String, String, Float)] = {
    val filterRecords = data.filter(record => tickers.contains(record.ticker))

    filterRecords.map(record => (record.date, record.ticker, record.close))
  }

  val tickers = List("TTM", "DB", "BNS")

  /** Invoked the list using the underscore and asterisk */
  val records = getRecords(tickers: _*)

  records.foreach(println)

}
