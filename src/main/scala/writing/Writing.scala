package writing

import java.io.{FileWriter}

import types.{Matrix}

import showing.{Entry, matrixAsCsv}

val writing: FileWriter => (Matrix[Entry] => Unit) = fileWriter =>
  matrix =>
    fileWriter.write(matrixAsCsv(matrix))
    fileWriter.close()

// OK    
