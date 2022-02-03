package com.pluralsight.methodsandfunctions.ImplementingFunctions

object FunctionInvocationWithExpressionBlocks extends App {

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

  val getStockDetails = (ticker: String) => records.filter(_.ticker == ticker)

  val ttmStockDetails = getStockDetails("TTM")
  println("--------------------------TTM")
  println(ttmStockDetails)

  val randomStockDetails = getStockDetails {
    val list = List("MSFT", "GOOG", "TM", "TTM", "DB", "BNS")
    val randomNumber = util.Random.nextInt(list.length)
    list(randomNumber)
  }

  println("-------------------------------random stock")
  println(randomStockDetails)
}
