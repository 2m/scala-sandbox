scalaVersion := "2.11.4"

libraryDependencies := Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

updateOptions := updateOptions.value.withConsolidatedResolution(true)
