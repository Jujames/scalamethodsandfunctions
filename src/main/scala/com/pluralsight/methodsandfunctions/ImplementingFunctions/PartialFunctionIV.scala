package com.pluralsight.methodsandfunctions.ImplementingFunctions

object PartialFunctionIV extends App {

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

  val printTechStocks = new PartialFunction[String, Unit] {

    def apply(ticker: String): Unit = for (lines <- data.filter(_.ticker == ticker)) {
      println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close} ")
    }
    def isDefinedAt(ticker: String): Boolean = ticker == "GOOG" || ticker == "MSFT"
  }

  val printMotorStocks = new PartialFunction[String, Unit] {

    def apply(ticker: String): Unit = for (lines <- data.filter(_.ticker == ticker)) {
      println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close}")
    }

    def isDefinedAt(ticker: String): Boolean = ticker == "TM" || ticker == "TTM"
  }

  val printTechOrMotorStocks = printTechStocks orElse printMotorStocks

  printTechStocks("TM")
  printMotorStocks("MSFT")
}
