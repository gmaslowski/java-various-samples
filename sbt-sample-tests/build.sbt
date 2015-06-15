name := """sbt-sample-tests"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.5"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12",
  "com.novocode" % "junit-interface" % "0.11"
)

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

