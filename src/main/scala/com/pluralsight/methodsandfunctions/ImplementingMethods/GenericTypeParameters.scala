package com.pluralsight.methodsandfunctions.ImplementingMethods

object GenericTypeParameters extends App {

  /** Making method more precise using GenericTypeParameters
   *  Instead of having three method that pick the stock at random */

    /** This is a generic method with the type parameter A stand for the data type
     * we use to invoke this method. It can be anything,
     * String, Integers, Doubles anything you use to invoke the method */
  def pickRandom[A](list: Seq[A]): A = {
    val randomNumber = util.Random.nextInt(list.length)
    list(randomNumber)
  }

  val stock = pickRandom(List("PS", "TSLA", "AAPL", "FB"))
  val quantity = pickRandom(List(10, 100, 1000, 10000, 1000000))
  val value = pickRandom(List(10.0, 20.0, 50.0, 80.0, 100.0))

  println(s"This pick for the day is ${quantity} shares of ${stock} " +
    s"if price is greater than ${value}")


}
