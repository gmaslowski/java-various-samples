libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.3.1",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)

fork in Test := false