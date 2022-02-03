package com.pluralsight.methodsandfunctions.GettingStarted

object DefKeyword extends App {

  def stockPrice: Int = {
    println("Returning Stock price")
    14
  }

  def volume: Int = {
    println("Returning volume")
    100
  }

  def finalValue: Int = stockPrice * volume

  println(s"The finale value is: $finalValue") // def finalValue: String = stockPrice * volume
  // def finalValueS: String = (stockPrice * volume).toString
  println("------------------------------------")

  def finaleValueAgain: Int = stockPrice * volume

  println(s"The final value is: $finaleValueAgain")
  println("-------------------------------------")

  def data: Array[String] = {
    println("Array is initialized")
    Array("MSFT", "GOOG", "TM")
  }

  println("Before accessing data")
  data.foreach(println)

  println("--------------------------")
  data.foreach(println)
}
