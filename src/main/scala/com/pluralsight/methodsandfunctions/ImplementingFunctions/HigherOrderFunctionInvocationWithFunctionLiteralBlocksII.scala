package com.pluralsight.methodsandfunctions.ImplementingFunctions

object HigherOrderFunctionInvocationWithFunctionLiteralBlocksII extends App {

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

 /** Using a function literal block
   * Requires the use of a method a higher order method which accepts as
   * an input Argument of function and it also involves the use of curried parameters. */

  def getStockDetails(ticker: String)(extractFunction: StockRecord => Float): Float = {
    val filterRecords = records.filter(_.ticker == ticker)
    assert(filterRecords.length == 1)

    extractFunction(filterRecords(0))
  }
    /** function literal block */
  val ttmStockDetails = getStockDetails("TTM") {
    (record: StockRecord) => record.high
  }
  println("--------------------------TTM high")
  println(ttmStockDetails)

  val googStockDetails = getStockDetails("GOOG") {
    (record: StockRecord) => record.low
  }
  println("------------------------------GOOG low")
  println(googStockDetails)



}
