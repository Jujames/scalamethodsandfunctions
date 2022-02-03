package com.pluralsight.methodsandfunctions.ImplementingFunctions



object PartialFunctionIIIPatternMatching extends App {

  val readFianceData = () => {
    val source = io.Source.fromFile("src/main/resource/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))

  }

  val data = readFianceData()

  val printStockRecords: PartialFunction[String, Unit] = {
    case ticker: String if List("MSFT", "GOOG", "TTM", "DB", "BNS").contains(ticker) =>
      for (line <- data.filter(_.ticker == ticker)) {

        println(s"Date: ${line.date} Ticker: ${line.ticker} Close: ${line.close}")
      }
  }
  /**  Map does not invoke the isDefinedAt method before invoking the printStockRecords method  */
  // List("DB", "TSLA")map {printStockRecords}

  /** Collect does invoke the isDefined so mismatch error */
     List("DB", "TSLA") collect {printStockRecords}
}
