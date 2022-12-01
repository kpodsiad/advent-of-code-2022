val scala3Version = "3.2.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "advent-of-code",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0-M6" % Test
  )
