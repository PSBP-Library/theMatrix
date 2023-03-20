import com.github.tototoshi.csv.{CSVReader, defaultCSVFormat}

import CSVReader.open

val names = open(new java.io.File("names.csv")).all().head

val some: String => Option[Amount] = z => Some(BigDecimal(z))

val xxxxxx: Option[Amount] = None

val payments = open(new java.io.File("payments.csv")).all().tail.map { paymentRow =>
  paymentRow.map { optionalAmountString =>
    if (optionalAmountString == "xxxxxx") {
      xxxxxx
    } else {
      some(optionalAmountString)
    }
  }
}
