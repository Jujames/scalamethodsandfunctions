package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.googStockRecords

import scala.annotation.tailrec

object TailRecursionII extends App {

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
  /** Method without tail recursion which mean it can not be optimized */
    @tailrec
  def rollingAverage(records: Vector[googStockRecords], numDays: Int): Unit = {

    if (records.length < numDays) {
      throw new Exception("Error so we can see the stack trace")
    } else {
      val averageClose = records.map(_.close).take(numDays).sum / numDays

      println(s"Rolling average close fo $numDays " +
        s"date ${records.head.date}: $averageClose")

      val updateRecords = records.drop(1)

      /** In order to apply the tail recursion optimization,
       *  the recursive call has to be the last call in a method */
      rollingAverage(updateRecords, numDays)
    }
  }
  rollingAverage(readFinanceData(), 10)
}
