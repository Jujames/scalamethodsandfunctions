package com.pluralsight.methodsandfunctions.ImplementingMethods

object Calculator extends App {

  def computeSum(a: Int, b: Int): Int = {
     a + b
  }
  def printSum(a: Int, b: Int) = {
    println("Sum of a and b is " + (a + b))
  }
/** Invoke the method using parenthesis and the value returned
 *  can be assigned ta a variable */
 // val result = computeSum(5, 6)
 // println("Result is: " + result)

  /** Invoke the printSum method  */
 // printSum(11, 12)

/** Both method belong to the singleton object, the Calculator object.
 *  so you can invoke these methods by using a reference to the calculator
 *  calculated, not computeSum calculate or not printSum */

  val result = Calculator.computeSum(5, 6)

  println("Result is: " + result)

  Calculator.printSum(11, 12)

}
