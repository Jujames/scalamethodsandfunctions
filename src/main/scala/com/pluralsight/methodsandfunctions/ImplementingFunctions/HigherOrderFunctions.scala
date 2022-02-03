package com.pluralsight.methodsandfunctions.ImplementingFunctions

object HigherOrderFunctions extends App {

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
/*
  println(records.getClass)

  for (record <- records) {
    println(record)
  }
  */
  val extractHighPrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.high)
  }

  val extractOpenPrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.open)
  }

  val extractClosePrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.close)
  }

  val extractPriceDelta = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.close - record.open)
  }
             /** This is a  Higher Order Function:
   Higher_order function accept function as input arguments, this also means function are first_class
              citizens in Scala.                   */
  val extractInfo = (records: Vector[StockRecord],
                     extractFunction: Vector[StockRecord] => Vector[(String, Float)]) => {
    extractFunction(records)
  }
   /** Calling the three separate Functions */
  println("Open: " + extractOpenPrice(records))
  println("Closed: " + extractClosePrice(records))
  println("Delta: " + extractPriceDelta(records))

  println("-------------------------------------")

  /** Calling the Higher Order Function: */
  println("Open: " + extractInfo(records, extractOpenPrice))
  println("Closed: " + extractInfo(records, extractClosePrice))
  println("Delta: " + extractInfo(records, extractPriceDelta))

}
