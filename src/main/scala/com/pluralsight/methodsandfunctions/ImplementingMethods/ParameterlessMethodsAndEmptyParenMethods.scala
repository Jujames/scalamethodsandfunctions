package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.googStockRecords

object ParameterlessMethodsAndEmptyParenMethods extends App {

 /** A method that accepts no inputs Arguments can be defined in the form
   *  of a Parameterless method or an Empty Pattern method.

   *  Parameterless methods are used when an attribute could have been implemented
   *  either as a field or a method. Based on the "uniform access principle" client
   *  code should not be affected by this decision.

   *  Parameterless method - the method takes in no input arguments so we eliminate the parenthesis. */
  def financeData: Vector[googStockRecords] = {
    val source = io.Source.fromFile("src/main/resources/googStocks.csv")
    for {
      line <- source.getLines().drop(1).toVector
      rows = line.split(",").map(_.trim)
    } yield googStockRecords(rows(0), rows(1).toFloat,
      rows(2).toFloat, rows(3).toFloat,
      rows(4).toFloat, rows(5).toFloat,
      rows(6).toDouble)
  }

 /** When you define a parameters list method,
   *  you invoke the method without specifying
   *  the parenthesis. */
  private val data = financeData

 /** More parameterless methods.
  * The advantage of parameterless methods is that
  * if we changed the def to val these will all become fields and the way
  * to access these fields is exactly the same way.
  */
// def numberOfRows: Int = data.size
  val numberOfRows: Int = data.size

  def minimumCloseValue: Double = data.map(_.close).min
  def maximumCloseValue: Double = data .map(_.close).max
  def averageCloseValue: Double = data.map(_.close).sum / data.size

  println(s"Number of rows: " + numberOfRows)
  println(s"Minimum close value: " + minimumCloseValue)
  println(s"Maximum close vale: " + maximumCloseValue)
  println(s"Average close value: " + averageCloseValue)

}
