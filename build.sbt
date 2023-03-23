val scala3Version = "3.2.2"


lazy val root = project
  .in(file("."))
  .settings(
    name := "theMatrix",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.8"
    
  )

