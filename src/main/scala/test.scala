val epsilon = 1.1e-30

val test = (payments: Payments) =>
  println(
    (mapFoldLeft(identity[Amount])(BigDecimal(0.0))(_ + _)(finalPersonRow(payments)) - BigDecimal(0.0)).abs < epsilon
  )
