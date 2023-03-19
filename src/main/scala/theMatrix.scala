@main def theMatrix: Unit =

  val names =
    List("John",       "Mary",       "Joe",        "Kelly",      "Donald",     "Mick"      )

  val some: Double => Option[Amount] = z => Some(BigDecimal(z))
  val ____________ : Option[Amount] = None    

  val payments = List(
    List(some(090.50), some(000.00), some(009.50), some(000.00), ____________, ____________),
    List(____________, ____________, some(030.30), some(000.00), some(069.70), some(000.00)),
    List(some(100.00), some(000.00), some(050.00), some(000.00), some(150.00), some(000.00)),
    List(some(000.00), some(000.00), some(050.00), some(150.00), some(000.00), some(050.00))
  )

  println()
  println("\t.-------------------------------------------------------------------------------------------------------.")
  print("\t|\t")
  names.foreach { name =>
    print(s"$name\t\t")
  }
  print("|")
  println()
  println("\t.-------------------------------------------------------------------------------------------------------.")
  payments.foreach { payment =>
    print("\t|\t")
    payment.foreach { optionalAmount => print(s"${optionalAmountAsString.asString(optionalAmount)}\t\t") }
    print("|")
    println()
  }
  println("\t.-------------------------------------------------------------------------------------------------------.")
  paymentMatrix(payments).foreach { payment =>
    print("\t|\t")
    payment.foreach { optionalAmount => print(s"${optionalAmountAsString.asString(optionalAmount)}\t\t") }
    print("|")
    println()
  }
  println("\t.-------------------------------------------------------------------------------------------------------.")
  print("\t|\t")
  finalPersonRow(payments).foreach { amount => print(s"${amountAsString.asString(amount)}\t\t") }
  print("|")
  println()
  println("\t.-------------------------------------------------------------------------------------------------------.")
  println()
  
  test(payments)

  // just in case formatting is done by accident (amount of blanks will go to 1)

  // val names =
  //   List("Luc",        "Maritza",    "Jos",        "Gaby",       "Daan",       "Laura"     )

