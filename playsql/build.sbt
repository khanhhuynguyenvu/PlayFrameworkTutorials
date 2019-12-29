name := """playsql"""
organization := "org"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.0"

libraryDependencies += guice
libraryDependencies += evolutions
libraryDependencies ++= Seq(
  javaJdbc,
  javaWs,
  javaJpa,
  "mysql" % "mysql-connector-java" % "5.1.35",
  "org.hibernate" % "hibernate-core" % "5.4.9.Final"
)
