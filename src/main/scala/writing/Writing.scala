package writing

import java.io.{FileWriter}

import types.{Matrix}

import showing.{Entry, theMatrixShow}

val writing: FileWriter => Matrix[Entry] => Unit = fileWriter =>
  matrix =>

    fileWriter.write(theMatrixShow.asString(matrix))

    fileWriter.close()
