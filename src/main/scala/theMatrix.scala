@main def theMatrix: Unit =

  println(s"${Console.BLACK}")
  println("\t.-------------------------------------------------------------------------------------------------------.")
  print("\t|\t")
  names.foreach { name =>
    import nameAsString.asString
    print(s"${asString(name)}\t\t")
  }
  println("|")
  println("\t.-------------------------------------------------------------------------------------------------------.")
  payments.foreach { payment =>
    import optionalAmountAsString.asString
    print("\t|\t")
    payment.foreach { optionalAmount => print(s"${asString(optionalAmount)}\t\t") }
    print("|")
    println()
  }
  println("\t.-------------------------------------------------------------------------------------------------------.")
  paymentMatrix(payments).foreach { payment =>
    import optionalAmountAsString.asString
    print("\t|\t")
    payment.foreach { optionalAmount => print(s"${asString(optionalAmount)}\t\t") }
    print("|")
    println()
  }
  println("\t|_______________________________________________________________________________________________________|")
  println("\t.                                                                                                       .")
  import amountAsString.asString
  print("\t|\t")
  finalPersonRow(payments).foreach { amount => print(s"${asString(amount)}\t\t") }
  print("|")
  println()
  println("\t._______________________________________________________________________________________________________.")
  println()

  test(payments)
