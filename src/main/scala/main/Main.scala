package main

import java.io.{File, FileWriter}

import types.{Row, Column, Matrix}

import reading.{reading}

import transforming.{
  Payment,
  paymentsMatrix,
  balancedPaymentsMatrix,
  balancedPersonsMatrix,
  balancedToBePaidRow,
  namesAndInfoRow,
  infosColumn
}

import showing.{Entry}

import writing.{writing}

@main def main(args: String*): Unit =
  val inputFile = new File(args(0))

  val theInputMatrix: Matrix[String] = reading(inputFile)(())

  val theLength: Int = theInputMatrix.head.length

  val thePaymentsMatrix: Matrix[Payment] = paymentsMatrix(theInputMatrix)
  val theBalancedPaymentsMatrix: Matrix[Payment] = balancedPaymentsMatrix(thePaymentsMatrix)
  val theBalancedPersonsMatrix: Matrix[Payment] = balancedPersonsMatrix(theBalancedPaymentsMatrix)
  val theBalancedToBePaidRow: Row[Payment] = balancedToBePaidRow(theBalancedPersonsMatrix)

  val theInfosColumn: Column[String] = infosColumn(theInputMatrix)

  val theNamesAndInfoRow: Row[Entry] = namesAndInfoRow(theInputMatrix)

  val theNamesAndInfoMatrix: Matrix[Entry] = List(theNamesAndInfoRow)
  val thePaymentsAndInfoMatrix: Matrix[Entry] =
    theInfosColumn.zip(thePaymentsMatrix).map { (info, paymentRow) => paymentRow ::: List(info) }
  val theBalancedPaymentsAndInfoMatrix: Matrix[Entry] =
    theInfosColumn.zip(theBalancedPaymentsMatrix).map { (info, paymentRow) => paymentRow ::: List(info) }
  val theBalancedToBePaidAndInfoMatrix: Matrix[Entry] = List(theBalancedToBePaidRow ::: List("to be paid"))

  val separatorMatrix: Matrix[Entry] = List(theNamesAndInfoRow.map { entry => "" })

  val theMatrix: Matrix[Entry] =
    theNamesAndInfoMatrix :::
      separatorMatrix :::
      thePaymentsAndInfoMatrix :::
      separatorMatrix :::
      theBalancedPaymentsAndInfoMatrix :::
      separatorMatrix :::
      theBalancedToBePaidAndInfoMatrix

  val outputFileWriter = new FileWriter(args(1), true)

  writing(outputFileWriter)(theMatrix)

// OK  