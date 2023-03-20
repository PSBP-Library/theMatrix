import com.github.tototoshi.csv.{CSVReader, defaultCSVFormat}

import CSVReader.open

@main def theMatrix: Unit =

  println("Please enter the name of your csv file")

  val file = new java.io.File(scala.io.StdIn.readLine())

  val names = open(file).all().head

  val payments =  open(file).all().tail.map { paymentRow =>
    val some: String => Option[Amount] = z => Some(BigDecimal(z))
    val xxxxxxxx: Option[Amount] = None
    paymentRow.map { optionalAmountString =>
      if (optionalAmountString == "xxxxxxxx") {
        xxxxxxxx
      } else {
        some(optionalAmountString)
      }
    }
  }

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
