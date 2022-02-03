package com.pluralsight.methodsandfunctions.ImplementingMethods

object CalculatorII extends App {

  def computeSum(a: Int, b: Int) = a + b

  /** A method defined using just curly brace and no = sign is a procedure,
   *  a procedure does not return anything, its result type is always UNIT
   *  Also known as a special type of method */

  def printSum(a: Int, b: Int): Unit = println("Sum of a and b is " + (a + b))


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
