package com.pluralsight.methodsandfunctions.ImplementingFunctions

/** Case classes are used to model immutable data and can be constructed
 * without the new keyword */
case class StockRecords(date: String,
                        open: Float,
                        high: Float,
                        low: Float,
                        close: Float,
                        adj_close: Float,
                        volume: Double)
