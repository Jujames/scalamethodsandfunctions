package com.pluralsight.methodsandfunctions.ImplementingMethods

import com.pluralsight.methodsandfunctions.ImplementingFunctions.StockRecord


object NestedMethodsII extends App {


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

    def printStockData(ticker: String): Unit = {


      println("Date    | Ticker | Close")
      printRecords()

      def printRecords(): Unit = {

    val filteredRecords = data.filter(_.ticker == ticker)
        for (row <- filteredRecords) {
          println(s"${row.date} | ${row.ticker}  | ${row.close}")
        }

        printSummary()

        def printSummary(): Unit = {

          printAverage()

          def printAverage(): Unit = {
            val averageClose = filteredRecords.filter(_.ticker == ticker).
              map(_.close).sum / filteredRecords.size
            println("Average close: " + averageClose)

            printStandardDeviation()

            def printStandardDeviation(): Unit = {
              var x = 0.0

              for(record <- filteredRecords) {
                x = x + Math.pow(record.close - averageClose , 2)
              }

              val variance = x / filteredRecords.size
              println("Standard deviation close: " + Math.sqrt(variance))
            }
          }
        }
       }
    }

    printStockData("BNS")

}