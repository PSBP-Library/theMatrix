package writing

import java.io.{FileWriter}

import types.{Matrix}

val writing: FileWriter => Matrix[String] => Unit = fileWriter =>
  outputMatrix =>
    outputMatrix.foreach { row =>
      row.foreach { string =>
        fileWriter.write(string)
      }
    }

    fileWriter.close()
