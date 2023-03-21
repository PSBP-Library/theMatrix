val epsilon = BigDecimal(1.1e-30)

val expectedValue = BigDecimal(0.0)

val evaluatedValue = (payments: Payments) => makeBalancedFinalPersonRow(payments).foldLeft(BigDecimal(0.0))(_ + _)

enum Balance:
  case OK extends Balance
  case KO extends Balance

val test = (payments: Payments) =>
  ((evaluatedValue(payments) - expectedValue).abs < epsilon) match {
    case true  => println(s"${Console.GREEN}Balance is ${Balance.OK}\n")
    case false => println(s"${Console.RED}Balance is ${Balance.KO}\n")
  }
