package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.googStockRecords
import com.pluralsight.methodsandfunctions.ImplementingMethods.RecursionII.{readFinanceData, rollingAverage}

import scala.annotation.tailrec

object TailRecursion extends App {

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
  /** A new stack frame will not be built for ach recursive call - all calls
   *  will be executed in a single stack frame by simply updating the input
   *  argument to the recursive call. */



  @tailrec
  def rollingAverage(records: Vector[googStockRecords], numDays: Int): Unit = {

    if (records.length < numDays) {
      println("Execution Complete!")
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
  rollingAverage(readFinanceData(), 7)




}
