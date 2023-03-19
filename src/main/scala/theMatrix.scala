@main def theMatrix: Unit =

  println(s"${Console.BLACK}")
  println("\t.-------------------------------------------------------------------------------------------------------.")
  print("\t|\t")
  names.foreach { name =>
    print(s"${Console.BLUE}$name${Console.BLACK}\t\t")
  }
  println("|")
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
  println("\t|_______________________________________________________________________________________________________|")
  println("\t.                                                                                                       .")
  print("\t|\t")
  finalPersonRow(payments).foreach { amount => print(s"${amountAsString.asString(amount)}\t\t") }
  print("|")
  println()
  println("\t._______________________________________________________________________________________________________.")
  println()
  
  test(payments)

  // just in case formatting is done by accident (amount of blanks will go to 1)

  // val names =
  //   List("Luc",        "Maritza",    "Jos",        "Gaby",       "Daan",       "Laura"     )

