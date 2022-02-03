package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object MethodEvaluationStrategies extends App {

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

  /** Cal by value: Is the strict evaluation strategy that Scala uses by
   *  default, here the expression corresponding to input arguments are
   *  evaluated before the function body is executed */

  def makeMomentumBasedTradingDecision(record: StockRecord, percentDelta: Float): Unit = {
    println(s"Calculating percentage move")

    val percentageMove = ((record.close - record.open) / record.open) * 100

    if (percentageMove > percentDelta) {
      println(s"Buy ${record.ticker}")
    } else if (percentageMove < -percentDelta) {
      println(s"Sell ${record.ticker}")
    } else {
      println(s"No call on ${record.ticker}")
    }
  }

  def getRecord(ticker: String): StockRecord = {
    println(s"Accessing record for $ticker")
    val filterRecords = records.filter(_.ticker == ticker)
    assert(filterRecords.length == 1)

    filterRecords(0)
  }

  println("--------------------")
  makeMomentumBasedTradingDecision(getRecord("MSFT"), 3)

  println("--------------------")
  makeMomentumBasedTradingDecision(getRecord("TM"), 3)

}
