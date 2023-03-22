package main

import java.io.{File, FileWriter}

import scala.io.{StdIn}

import types.{Row, Column, Matrix}

import reading.{reading}

import transforming.{Payment}

import writing.{Entry, entryShow}

import transforming.{
  paymentsMatrix,
  balancedPaymentsMatrix,
  balancedPersonsMatrix,
  balancedToBePaidRow,
  namesAndInfoRow,
  infosColumn
}

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
            theBalancedPaymentsAndInfoMatrix 
            ::: separatorMatrix :::
              theBalancedToBePaidAndInfoMatrix

  val theOutputMatrix: Matrix[String] = theMatrix.map { row =>
    row.zipWithIndex.map { indexedEntry => entryShow.asEntry(theLength)(indexedEntry._2, indexedEntry._1) }
  }

  val outputFileWriter = new FileWriter(args(1), true)

  theOutputMatrix.foreach { row =>
    row.foreach { entry =>
      outputFileWriter.write(entry)
    }
  }

  outputFileWriter.close()
