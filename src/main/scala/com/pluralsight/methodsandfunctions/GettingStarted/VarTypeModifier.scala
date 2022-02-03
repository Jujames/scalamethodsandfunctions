package com.pluralsight.methodsandfunctions.GettingStarted

object VarTypeModifier extends App {

  var stockPrice = 14
  var volume = 100

  volume = 1000

  var finaleValue = stockPrice * volume
  println(s"Final value is: $finaleValue")

  var data = {
    println("Array is initialized");
    Array(
      "MSFT", "GOOG", "TM"
    )
  }

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data = {
    println("New Array is initialized"); Array("AAPL")
  }
  data.foreach(println)

}
