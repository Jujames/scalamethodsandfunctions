package com.pluralsight.methodsandfunctions.ImplementingFunctions

object HigherOrderFunctionsIII extends App {

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

  /** HigherOrderFunction return function as the return value */
  val getExtractFunction = (functionName: String, records: Vector[StockRecord]) => {
    if (functionName == "high") {
      () => for (record <- records) yield (record.ticker, record.high)
    } else if (functionName == "open") {
      () => for (record <- records) yield (record.ticker, record.open)
    } else if (functionName == "close") {
      () => for (record <- records) yield (record.ticker, record.close)
    } else {
      () => for (record <- records) yield (record.ticker, record.close - record.open)
    }
  }

  val openFunction = getExtractFunction("open", records)
  val closeFunction = getExtractFunction("close", records)
  val deltaFunction = getExtractFunction("delta", records)

  println("Open: " + openFunction())
  println("Close "+ closeFunction())
  println("Delta: " + deltaFunction())

}
