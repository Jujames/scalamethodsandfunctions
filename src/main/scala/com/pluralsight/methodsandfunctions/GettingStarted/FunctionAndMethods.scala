package com.pluralsight.methodsandfunctions.GettingStarted

object FunctionAndMethods extends App {

  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def getNumRowsMethods(): Int = data.length

  val getNumRowsFubction = () => data.length

  // println("Total number of rows (method): " + getNumRowsMethods)
  // println("Total number of rows (function): " + getNumRowsFubction())

  //  println(getNumRowsMethods.getClass)
  //  println(getNumRowsFubction.getClass)
  println(getNumRowsFubction.apply())
  println(getNumRowsFubction.isInstanceOf[Function0[_]])
}
