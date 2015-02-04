scalaVersion := "2.11.5"

libraryDependencies := Seq(
  "org.scalaz" %% "scalaz-core" % "7.1.0",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "com.github.mauricio" %% "mysql-async" % "0.2.15",
  "com.typesafe.akka" %% "akka-actor" % "2.3.9"
)

updateOptions := updateOptions.value.withConsolidatedResolution(true)
