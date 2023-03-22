package showing

import transforming.{Amount, Payment}

type Entry = String | Payment

trait Show[Z]:
  val asString: Z => String

  val asEntry: Int => (Int, Z) => String =
    i =>
      (j, z) =>
        s"${asString(z)}\t${
            if (j == i - 1) { "\n" }
            else { "," }
          }"

given stringShow: Show[String] with
  val asString: String => String = string => string

given paymentShow: Show[Payment] with
  val asString: Payment => String = payment =>
    if (payment.isDefined) {
      s"${payment.get.setScale(2, BigDecimal.RoundingMode.HALF_UP)}"
    } else {
      " "
    }

given entryShow: Show[Entry] with
  val asString: Entry => String = entry =>
    if (entry.isInstanceOf[String]) {
      stringShow.asString(entry.asInstanceOf[String])
    } else {
      paymentShow.asString(entry.asInstanceOf[Payment])
    }