package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.googStockRecords

object RecursionII extends App {

  def readFinanceData(): Vector[googStockRecords] = {
    val source = io.Source.fromFile("src/main/resources/googStocks.csv")
    for {
      line <- source.getLines().drop(1).toVector
      rows = line.split(",").map(_.trim)
    } yield googStockRecords(rows(0), rows(1).toFloat,
      rows(2).toFloat, rows(3).toFloat,
      rows(4).toFloat, rows(5).toFloat,
      rows(6).toDouble)
  }
  /** Using the function paradigm we will implement the rollingAverage recursive */

  def rollingAverage(records: Vector[googStockRecords], numDays: Int): Unit = {

    if (records.length < numDays) {
      println("Execution Complete!")
    } else {

      /** After the } else { retains the recursive call */
      val averageClose = records.map(_.close).take(numDays).sum / numDays

      println(s"Rolling average close fo $numDays " +
      s"date ${records.head.date}: $averageClose")

  /** Calculate and update records value by dropping the first record. */
     val updateRecords = records.drop(1)

     /** Observe that we assigned this to a val type modifier and passed this
      *  updated record back in to our next call rollingAverage,
      *  this is a recursive call */
      rollingAverage(updateRecords, numDays)
    }
  }
  rollingAverage(readFinanceData(), 7)

}
