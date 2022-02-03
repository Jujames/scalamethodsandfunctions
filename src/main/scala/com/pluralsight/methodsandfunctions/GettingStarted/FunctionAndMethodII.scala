package com.pluralsight.methodsandfunctions.GettingStarted

object FunctionAndMethodII extends App {
  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def existsMethod(ticker: String): Boolean = data.contains(ticker)

  val existFunction = (ticker: String) => data.contains(ticker)

  /** any method that you have defined can always be converted to function Object */
  // val exists = existsMethod _
  /** ^^ This is the same as this wrapped method */
  val exists = (ticker: String) => existsMethod(ticker)

  println("Does PS exist (method): " + existsMethod("PS"))
  println("Does TM exist (function): " + existFunction("TM"))
  println("Does GOOG exist (function): " + exists("GOOG"))

}
