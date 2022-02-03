package com.pluralsight.methodsandfunctions.ImplementingFunctions

object FunctionLiteral extends App {
  /** Function literal: In the source code get compiled into a class
   * that is instantiated at runtime as a function object.
   */
  (x: Int) => x * 100

  /** Function literal need to be assigned to a variable */
  var multiplyBy = (x: Int) => x * 100
  println(multiplyBy(3))

  /** Once you have a variable that holds a function value,
   * you can reassign that variable to another function value.
   * But they should be of the same type.
   * NOOOOOO ---> multiplyBy = (x: String) => x.toUpperCase() <---------
   */
  multiplyBy = (x: Int) => x * 1000

  /** Function literal can be invoked with input arguments and the return value */
  println(multiplyBy(3))

  /** Function literal can defined using expression blocks which holds
   * multiple statement within curly braces */
  var calculateResult = (x: Int, y: Int) => {
    val sum = x + y
    val diff = x - y
    val product = x * y
    val quotient = x / y

    (sum, diff, product, quotient)
  }

  /** Function literal can be invoked with input arguments and the return value */
  println("------------------- 10 and 5")
  println(calculateResult(10, 5))

  println("---------------- 40 and 8")
  println(calculateResult(40, 8))
}
