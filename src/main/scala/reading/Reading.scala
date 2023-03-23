package reading

import java.io.{File}

import com.github.tototoshi.csv.{CSVReader, defaultCSVFormat}
import CSVReader.open

import types.{Matrix}

val reading: File => (Unit => Matrix[String]) = file =>
  _ =>
    val matrix = open(file).all()
    matrix

// OK
