package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord

object NestedMethods extends  App {
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

  def printRecords(ticker: String): Unit = {
    println("Date    | Ticker | Close")

    /**This is a nested method because it's defined within an outer method,
     * it is possible for nested method to have the same name as long as the signature
     * of the method is different.
     * Here the nested Method is printing out the individual records */
    def printRecords(): Unit = {
      for (row <- data.filter(_.ticker == ticker)) {

        println(s"${row.date} | ${row.ticker} | ${row.close}")
      }
    }
    /** When you define a nested method within an outer method, the nested
     *  method can be invoked only within the scope of the outer method */

    /** Here we invoke the nested method printRecords */
    printRecords()
  }
  /** To print out the details for the bank of Nova Scotia, Outside
   *  within the class I invoke the printRecords Outer method this printRecords
   *  is invoked using a ticker as an input argument.*/
  printRecords("BNS")
}

