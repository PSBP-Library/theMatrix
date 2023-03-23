package showing

import types.{Matrix}

import transforming.{Payment}

trait Show[Z]:
  val asString: Z => String

given stringShow: Show[String] with
  val asString: String => String = string => string

given paymentShow: Show[Payment] with
  val asString: Payment => String = payment =>
    if (payment.isDefined) {
      s"${payment.get.setScale(2, BigDecimal.RoundingMode.HALF_UP)}"
    } else {
      " "
    }

type Entry = String | Payment

given entryShow: Show[Entry] with
  val asString: Entry => String = entry =>
    if (entry.isInstanceOf[String]) {
      stringShow.asString(entry.asInstanceOf[String])
    } else {
      paymentShow.asString(entry.asInstanceOf[Payment])
    }

given theMatrixShow: Show[Matrix[Entry]] with
  val asString: Matrix[Entry] => String = entryMatrix =>
    val length: Int = entryMatrix.head.length

    entryMatrix
      .map { row =>
        row.zipWithIndex.map { (z, j) =>
          s"${entryShow.asString(z)}${
              if (j == length - 1) { "\n" }
              else { "," }
            }"
        }
      }
      .map { row =>
        row.foldLeft("")(_ + _)
      }
      .foldLeft("")(_ + _)

