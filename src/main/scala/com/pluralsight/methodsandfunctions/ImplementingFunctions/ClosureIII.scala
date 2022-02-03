package com.pluralsight.methodsandfunctions.ImplementingFunctions

object ClosureIII extends App {

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

  val getDecisionMakerFunction = (records: Vector[StockRecords]) => {

    val makeDecision = (percentDelta: Float) => {
      val filteredRecords = records.filter(_.date == date)
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

  var date = "2020-02-06"

  println("----------------------")
  val decisionMaker1 = getDecisionMakerFunction(readFinanceData())

  decisionMaker1(2)
}
