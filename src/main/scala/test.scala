val epsilon = 1.1e-30

val expectedValue = BigDecimal(0.0)

val evaluatedValue = (payments: Payments) => finalPersonRow(payments).foldLeft(BigDecimal(0.0))(_ + _)

enum Result:
  case OK extends Result
  case KO extends Result

val test = (payments: Payments) =>
  ((evaluatedValue(payments) - expectedValue).abs < epsilon) match {
    case true  => println(s"${Console.GREEN}Result.OK\n")
    case false => println(s"${Console.RED}Result.KO\n")
  }
