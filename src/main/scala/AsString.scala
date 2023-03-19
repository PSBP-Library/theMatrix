trait AsString[Z]:
  val asString: Z => String

given amountAsString: AsString[Amount] with
  val asString: Amount => String = bigDecimal => s"${bigDecimal.setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble}"

given optionalAmountAsString: AsString[Option[Amount]] with
  val asString: Option[Amount] => String = optionalAmount =>
    if (optionalAmount.isDefined) {
      amountAsString.asString(optionalAmount.get)
    } else {
      "xxxxxx"
    }
