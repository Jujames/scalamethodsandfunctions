package com.pluralsight.methodsandfunctions.ImplementingFunctions

object PartialFunctionWithPatternMatching {

  def main(args: Array[String]): Unit = {

    val divide64By: PartialFunction[Int, Int] = {
      case x: Int if x != 0 => 64 / x
    }

    println("Defined at 11: " + divide64By.isDefinedAt(11))
    println("Defined at 0: " + divide64By.isDefinedAt(0))

    println("Divide 64 by 3: " + (if(divide64By.isDefinedAt(3)) divide64By(3)))
  }
}
