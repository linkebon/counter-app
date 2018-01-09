import scala.sys.process.Process

name := """counter app"""
organization := "com.linkebon"

version := "1.0.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies += guice

lazy val buildFrontends = taskKey[Unit]("Build frontends")

buildFrontends := {
  todoAppFrontend.value
}

lazy val todoAppFrontend = taskKey[Unit]("generate counterApp")
todoAppFrontend := {
  val frontendPath = baseDirectory.value.getPath + "/frontend/react-redux-counter-app"
  Process(s"npm run generateFrontend --prefix $frontendPath").!
}