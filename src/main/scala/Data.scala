val names =
List("John",       "Mary",       "Joe",        "Kelly",      "Donald",     "Mick"      )

val some: Double => Option[Amount] = z => Some(BigDecimal(z))
val ____________ : Option[Amount] = None    

val payments = List(
List(some(090.50), some(000.00), some(010.50), some(-01.00), ____________, ____________),
List(____________, ____________, some(030.30), some(000.00), some(069.70), some(000.00)),
List(some(100.00), some(000.00), some(050.00), some(000.00), some(150.00), some(000.00)),
List(some(000.00), some(000.00), some(050.00), some(150.00), some(000.00), some(050.00))
)