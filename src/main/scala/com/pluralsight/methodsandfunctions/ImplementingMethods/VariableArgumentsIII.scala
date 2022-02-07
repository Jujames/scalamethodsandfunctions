package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object VariableArgumentsIII extends App {def readFinanceData(): Vector[StockRecord] = {
  val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
  for {
    line <- source.getLines().drop(1).toVector
    rows = line.split(",").map(_.trim)
  } yield StockRecord(rows(0), rows(1).toFloat,
    rows(2).toFloat, rows(3).toFloat,
    rows(4).toFloat, rows(5))
}

  private val data = readFinanceData()

  /** You can except regular arguments along with variable arguments.
   *  When you define a Scala method with variable number of arguments
   *  they should not be the first argument in you argument list, they
   *  must come at the end. */

  def getRecords(date: String, tickers: String*): Vector[(String, String, Float)] = {
    val dateFilteredRecords = data.filter(_.date == date)

    val filteredRecords = dateFilteredRecords.filter(
      record => tickers.contains(record.ticker))

    filteredRecords.map(record => (record.date, record.ticker, record.close))
  }

    val tickers = List("TTM", "DB", "BNS")
    val records = getRecords(date = "12-06-2020", "TTM", "DB", "BNS")

    records.foreach(println)




}
