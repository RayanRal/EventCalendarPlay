name := """PetProjectCalendar"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

val h2 = "com.h2database" % "h2" % "1.2.127"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.squeryl" % "squeryl_2.11" % "0.9.5-7",
//  "org.postgresql" % "postgresql" % "9.3-1101-jdbc41",
  h2,
  "com.google.code.gson" % "gson" % "2.2.4"
)


