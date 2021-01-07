import com.scalapenos.sbt.prompt.SbtPrompt.autoImport._
import com.scalapenos.sbt.prompt._

ThisBuild / scalaVersion := "3.0.0-M3"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "dev.profunktor"

promptTheme := PromptTheme(
  List(
    text("[sbt] ", fg(105)),
    text(_ => "newtypes", fg(15)).padRight(" λ ")
  )
)

lazy val root = (project in file("."))
  .settings(
    licenses += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")),
    testFrameworks += new TestFramework("munit.Framework"),
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.20" % Test
  )
