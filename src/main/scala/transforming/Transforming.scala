package transforming

import types.{Row, Column, Matrix}

type Amount = BigDecimal

type Payment = Option[Amount]

val paymentsMatrix: Matrix[String] => Matrix[Payment] = stringMatrix =>
  stringMatrix.tail.map(_.reverse).map(_.tail).map(_.reverse).map { paymentRow =>
    val somePayment: String => Payment = z => Some(BigDecimal(z))
    val noPayment: Payment = None
    paymentRow.map { string =>
      if (string == "        ") {
        noPayment
      } else {
        somePayment(string)
      }
    }
  }

val totalAmount: Row[Payment] => Some[Amount] = paymentRow =>
  Some(
    paymentRow
      .map { payment =>
        if (payment.isDefined) { payment.get }
        else { BigDecimal(0.0) }
      }
      .foldLeft(BigDecimal(0.0))(_ + _)
  )

val numberOfPayers: Row[Payment] => Int = paymentRow =>
  paymentRow
    .map { (payment: Payment) =>
      if (payment.isDefined) { 1 }
      else { 0 }
    }
    .foldLeft(0)(_ + _)

val balancedPaymentsMatrix: Matrix[Payment] => Matrix[Payment] = paymentRow =>
  paymentRow.map { payment =>
    val total = totalAmount(payment).get
    val payers = numberOfPayers(payment)
    payment.map { payment =>
      if (payment.isDefined) {
        val amount = payment.get
        Some(amount - total / payers)
      } else { None }
    }
  }

val balancedPersonsMatrix: Matrix[Payment] => Matrix[Payment] = _.transpose

val balancedToBePaidRow: Matrix[Payment] => Row[Payment] = balancedPersonsMatrix =>
  balancedPersonsMatrix.map(totalAmount)

val namesAndInfoRow: Matrix[String] => Row[String] = stringMatrix => stringMatrix.head

val infosColumn: Matrix[String] => Column[String] = stringMatrix => stringMatrix.map(_.last).tail
