package showing

import types.{Row, Matrix}

import utils.{stringSum}

import transforming.{Payment}

trait Show[Z]:
  val asString: Z => String

given stringShow: Show[String] with
  val asString: String => String = string => string

val stringAsString: String => String = stringShow.asString

given paymentShow: Show[Payment] with
  val asString: Payment => String = payment =>
    if (payment.isDefined) {
      s"${payment.get.setScale(2, BigDecimal.RoundingMode.HALF_UP)}"
    } else {
      ""
    }

val paymentAsString: Payment => String = paymentShow.asString

type Entry = String | Payment

given entryShow: Show[Entry] with
  val asString: Entry => String = entry =>
    entry match {
      case (string: String)   => stringAsString(string)
      case (payment: Payment) => paymentAsString(payment)
    }

val entryAsString: Entry => String = entryShow.asString

val rowAsCsv: Row[Entry] => String = entryRow =>
  val length: Int = entryRow.length
  stringSum(entryRow.zipWithIndex.map { (z, j) =>
    s"${entryAsString(z)}${
        if (j == length - 1) { "\n" }
        else { "," }
      }"
  })

given matrixShow: Show[Matrix[Entry]] with
  val asString: Matrix[Entry] => String = entryMatrix => stringSum(entryMatrix.map(rowAsCsv))

val matrixAsCsv: Matrix[Entry] => String = matrixShow.asString

// OK
