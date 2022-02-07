package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.googStockRecords


object ParameterlessMethodsAndEmptyParenMethodsII extends App {

/** An empty-paren method: is recommended when there are no parameters
 *  and the method accesses but does not change mutable state i.e.
 *  by reading fields of the contained objects*/

  def financeData(): Vector[googStockRecords] = {
    val source = io.Source.fromFile("src/main/resources/googStocks.csv")
    for {
      line <- source.getLines().drop(1).toVector
      rows = line.split(",").map(_.trim)
    } yield googStockRecords(rows(0), rows(1).toFloat,
      rows(2).toFloat, rows(3).toFloat,
      rows(4).toFloat, rows(5).toFloat,
      rows(6).toDouble)
  }

  private val data = financeData()

  def numberOfRows: Int = data.size
  def minimumCloseValue: Double = data.map(_.close).min
  def maximumCloseValue: Double = data .map(_.close).max
  def averageCloseValue: Double = data.map(_.close).sum / data.size

  println(s"Number of rows: " + numberOfRows)
  println(s"Minimum close value: " + minimumCloseValue)
  println(s"Maximum close vale: " + maximumCloseValue)
  println(s"Average close value: " + averageCloseValue)


}
