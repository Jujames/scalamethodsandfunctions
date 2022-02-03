package com.pluralsight.methodsandfunctions.ImplementingFunctions

object PlaceholderII extends App {
  /** Function literal can be In Scala can be defined in with any number
   * of input arguments. */

  val sayHello = () => println("Hello Function literal")
  val multiplyBy100 = (x: Int) => x * 100
  val addTwoNumbers = (x: Int, y: Int) => x + y
  val addThreeNumbers = (x: Int, y: Int, z: Int) => x + y + z
  val addThreeNumAndAString = (x: Int, y: Int, z: Int, me: String) => x + y + z + me

  sayHello()
  println(multiplyBy100(8))
  println(addTwoNumbers(5, 6))
  println(addThreeNumbers(6, 3, 10))
  println(addThreeNumAndAString(5, 5, 5, " My code I made Hope it works!"))

  println("-------------------------")

  println("sayHello.isInstanceOf[Function0[]]: " +
    sayHello.isInstanceOf[() => _])
  println("multiplyBy100.isInstanceOf[Function1[_,_]]: " +
    multiplyBy100.isInstanceOf[(_) => _])
  println("addTwoNumbers.isInstanceOf[Function2[_,_,_]]: " +
    addTwoNumbers.isInstanceOf[(_, _) => _])
  println("addThreeNumbers.isInstanceOf[Function3[_,_,_,_]]: " +
    addThreeNumbers.isInstanceOf[(_, _, _) => _])
  println("addThreeNumAndAString.isInstanceOfFunction4[_,_,_,_,_]]: " +
    addThreeNumAndAString.isInstanceOf[(_, _, _, _) => _])


}
