package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.googStockRecords

/** As a functional programming lang in Scala it's often preferable
 *  that you write your code using recursion instead var types in your code */

object Recursion extends App {

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

  def rollingAverage(numDays: Int): Unit = {

    /** Using a var rather than val makes the program less
     * functional and more imperative */

    var records = readFinanceData()
    while (records.length >= numDays) {
      val averageClose = records.map(_.close).take(numDays).sum / numDays
      println(s"Rolling average close for $numDays days " +
      s"date ${records.head.date}: $averageClose")

      records = records.drop(1)
    }

    println("Execution Complete!")
  }

  rollingAverage(7)

}
