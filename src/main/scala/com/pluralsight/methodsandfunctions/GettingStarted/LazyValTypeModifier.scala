package com.pluralsight.methodsandfunctions.GettingStarted

object LazyValTypeModifier extends App {

  var stockPrice = 14
  lazy val volume = {
    println("Assigning val"); 100
  }
  // val volume = {println("Assigning val"); 100}

  println("Calculating final value")
  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
  println("------------------------------")

  lazy val data = {
    println("Array is initialized")
    Array("MSFT", "GOOG", "TM")
  }

  println("Before accessing data")
  data.foreach(println)

  println("----------------------")
  data.foreach(println)
}
