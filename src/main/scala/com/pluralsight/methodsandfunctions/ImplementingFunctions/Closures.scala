package com.pluralsight.methodsandfunctions.ImplementingFunctions

object Closures extends App {

  def readFinanceData():Vector[StockRecords] = {
    val source = io.Source.fromFile("src/main/resources/googStocks.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecords(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)
  }

  val getDecisionMakerFunction = (records: Vector[StockRecords], date: String) => {

    val currDate = date
    val currRecords = records
    //println(currDate)
    //currRecords.map(println)
    //println(currRecords(6))

    /** The function value created at runtime from this function literal is called a CLOSURE where,
        the value of the free variable referenced from within the function are capture at
        the time the function object is instantiated. */

    val makeDecision = (percentDelta: Float) => {
      val filteredRecords = currRecords.filter(_.date == currDate)
      assert(filteredRecords.length == 1)
      //println(filteredRecords(0))

      val record = filteredRecords.head
      val percentageMove = ((record.close - record.open) / record.open) * 100

      if (percentageMove > percentDelta) {
        println(s"Buy based on date ${record.date}, " +
        s"percentage move $percentageMove")
      } else if (percentageMove < -percentDelta) {
        println(s"Sell based on date ${record.date}, " +
        s" percentage move $percentageMove")
      } else {
        println(s"No call based on date ${record.date}, " +
        s"percentage move $percentageMove")
      }
    }

    /** This returned function is a closure which contains reference to the
     * value defined outside the function: ->  currDate and currRecords*/
   makeDecision
  }

  println("----------------------")
  val decisionMaker1 = getDecisionMakerFunction(readFinanceData(), "2020-02-06")
  println("----------------------")
  val decisionMaker2 = getDecisionMakerFunction(readFinanceData(), "2020-02-07")

  decisionMaker1(1)
  decisionMaker2(1)
}
