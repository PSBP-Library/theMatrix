trait AsString[Z]:
  val asString: Z => String

val blueName = (name: Name) => s"${Console.BLUE}${name}${Console.BLACK}"

given nameAsString: AsString[Name] with
  val asString: Name => String = name => blueName(name)

val blueAmount = (amount: Amount) =>
  s"${Console.BLUE}${amount.setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble}${Console.BLACK}"

val redAmount = (amount: Amount) =>
  s"${Console.RED}${amount.setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble}${Console.BLACK}"

val greenAmount = (amount: Amount) =>
  s"${Console.GREEN}${amount.setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble}${Console.BLACK}"

given amountAsString: AsString[Amount] with
  val asString: Amount => String = amount =>
    if (amount == 0) {
      blueAmount(amount)
    } else if (amount < 0) {
      redAmount(amount)
    } else {
      greenAmount(amount)
    }

given optionalAmountAsString: AsString[Option[Amount]] with
  val asString: Option[Amount] => String = optionalAmount =>
    if (optionalAmount.isDefined) {
      amountAsString.asString(optionalAmount.get)
    } else {
      "xxxxxx"
    }
