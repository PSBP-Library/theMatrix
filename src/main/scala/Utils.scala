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

val some: Double => Option[Amount] = z => Some(BigDecimal(z))
val ____________ : Option[Amount] = None
