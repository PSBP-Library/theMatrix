val totalAmount =
  mapFoldLeft { (optionalAmount: Option[Amount]) =>
    if (optionalAmount.isDefined) { optionalAmount.get }
    else { BigDecimal(0.0) }
  }(BigDecimal(0.0))(_ + _)

val numberOfDefinedAmounts =
  mapFoldLeft { (optionalAmount: Option[Amount]) =>
    if (optionalAmount.isDefined) { 1 }
    else { 0 }
  }(0)(_ + _)
