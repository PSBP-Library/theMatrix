// makeBalancedPaymentMatrix(payments) contains, for all payments, amounts paid too little or too much

val makeBalancedPaymentMatrix = (payments: Payments) =>
  payments.map { payment =>
    val total = totalAmount(payment)
    val participants = numberOfDefinedAmounts(payment)
    payment.map { optionalAmount =>
      if (optionalAmount.isDefined) {
        val amount = optionalAmount.get
        Some(amount - total / participants)
      } else { None }
    }
  }
