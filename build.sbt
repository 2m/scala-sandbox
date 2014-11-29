scalaVersion := "2.11.4"

libraryDependencies := Seq(
  "org.scalaz" %% "scalaz-core" % "7.1.0",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

updateOptions := updateOptions.value.withConsolidatedResolution(true)
