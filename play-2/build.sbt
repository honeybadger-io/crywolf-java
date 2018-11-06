name := """play-2"""
organization := "io.honeybadger"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

resolvers += Resolver.mavenLocal

libraryDependencies += guice
libraryDependencies += "io.honeybadger" % "honeybadger-java" % "2.0.0-SNAPSHOT"