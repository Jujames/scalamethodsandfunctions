package com.pluralsight.methodsandfunctions.ImplementingFunctions

object PartialFunction {

  def main(args: Array[String]): Unit = {
   /** A Partial function caters to only a subset of possible
    * data for which it has beed defined */

    val divide64By = new PartialFunction[Int, Int] {
      def apply(x: Int): Int =  64 / x

      def isDefinedAt(x:Int): Boolean = x != 0
    }
   /** Used to define the function */
    println("Defined at 11: " + divide64By.isDefinedAt(11))
    println("Defined at 0: " + divide64By.isDefinedAt(0))

   /** Used in a IF expression */
    println("Divide 64 by 3: " + (if(divide64By.isDefinedAt(3)) divide64By(3)))
  }
}
