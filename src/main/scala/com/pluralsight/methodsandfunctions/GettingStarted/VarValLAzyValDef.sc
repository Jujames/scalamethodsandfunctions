val volume = 1000        // Immutable

volume
println(s"Volume is: $volume")

var stockPrice = 79         // mutable
println(s"Stock price is: $stockPrice")

stockPrice = 78
println(s"Now stock price is $stockPrice")

def volume: Int = 1000

def stockPrice: Int = 79

def finalValue: Int = stockPrice * volume

finalValue

val faceValue = 5

lazy val lazyFaceValue = 5

faceValue

lazyFaceValue

