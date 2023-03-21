import com.github.tototoshi.csv.{CSVReader, defaultCSVFormat}

import CSVReader.open

@main def theMatrix: Unit =

  println("Please enter the name of your csv file")

  val file = new java.io.File(scala.io.StdIn.readLine())

  val matrix = open(file).all()

  val namesRow = matrix.head.tail

  val infosRow = matrix.map(row => row.head).tail

  val paymentMatrix = matrix.tail.map { paymentRow =>
    val some: String => Option[Amount] = z => Some(BigDecimal(z))
    val xxxxxxxx: Option[Amount] = None
    paymentRow.tail.map { optionalAmountString =>
      if (optionalAmountString == "xxxxxxxx") {
        xxxxxxxx
      } else {
        some(optionalAmountString)
      }
    }
  }

  val paymentWithInfoMatrix: List[List[Name | Option[Amount]]] = infosRow.zip(paymentMatrix).map(_ :: _)

  println(s"${Console.BLACK}")
  println(
    "\t\t\t\t\t.-------------------------------------------------------------------------------------------------------."
  )
  print("\t\t\t\t\t|\t")
  namesRow.foreach { name =>
    import nameAsString.asString
    print(s"${asString(name)}\t\t")
  }
  println("|")
  println(
    "\t.-------------------------------.-------------------------------------------------------------------------------------------------------."
  )
  paymentWithInfoMatrix.map { row =>
    print("\t| ")
    row.foreach { entry =>
      if (entry.isInstanceOf[Name]) {
        import nameAsString.asString
        print(s"${asString(entry.asInstanceOf[Name])}\t|\t")
      } else {
        import optionalAmountAsString.asString
        print(s"${asString(entry.asInstanceOf[Option[Amount]])}\t\t")
      }
    }
    print("|")
    println()
  }
  println(
    "\t.-------------------------------.------------------------------------------------------------------........-----------------------------."
  )
  makeBalancedPaymentMatrix(paymentMatrix).foreach { paymentRow =>
    print("\t\t\t\t\t|\t")
    paymentRow.foreach { optionalAmount =>
      import optionalAmountAsString.asString
      print(s"${asString(optionalAmount)}\t\t")
    }
    print("|")
    println()
  }
  println(
    "\t\t\t\t\t|_______________________________________________________________________________________________________|"
  )
  println(
    "\t\t\t\t\t|                                                                                                       |"
  )
  print("\t\t\t\t\t|\t")
  makeBalancedFinalPersonRow(paymentMatrix).foreach { amount =>
    import amountAsString.asString
    print(s"${asString(amount)}\t\t")
  }
  print("|")
  println()
  println(
    "\t\t\t\t\t|_______________________________________________________________________________________________________|"
  )
  println()

  test(paymentMatrix)
