val totalAmount = (optionalAmounts: List[Option[Amount]]) =>
  optionalAmounts
    .map { (optionalAmount: Option[Amount]) =>
      if (optionalAmount.isDefined) { optionalAmount.get }
      else { BigDecimal(0.0) }
    }
    .foldLeft(BigDecimal(0.0))(_ + _)

val numberOfDefinedAmounts = (optionalAmounts: List[Option[Amount]]) =>
  optionalAmounts
    .map { (optionalAmount: Option[Amount]) =>
      if (optionalAmount.isDefined) { 1 }
      else { 0 }
    }
    .foldLeft(0)(_ + _)
