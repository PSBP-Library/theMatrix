trait AsString[Z]:
  val asString: Z => String

given amountAsString: AsString[Amount] with
  val asString: Amount => String = amount => 
    if(amount == 0) {
      s"${Console.BLUE}${amount.setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble}${Console.BLACK}"
    } else if(amount < 0) {
      s"${Console.RED}${(-amount).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble}${Console.BLACK}"
    } else {
      s"${Console.GREEN}${amount.setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble}${Console.BLACK}"
    }

given optionalAmountAsString: AsString[Option[Amount]] with
  val asString: Option[Amount] => String = optionalAmount =>
    if (optionalAmount.isDefined) {
      amountAsString.asString(optionalAmount.get)
    } else {
      "xxxxxx"
    }
