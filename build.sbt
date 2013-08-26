name := "postmark-scala"

description := "Scala binding for the Postmark API"

version := "1.0"

organization := "com.postmark.scala"

scalaVersion := "2.10.0"

crossScalaVersions := Seq(
  "2.9.0", "2.9.0-1","2.9.1", "2.9.1-1", "2.9.2", "2.9.3",
  "2.10.0")

libraryDependencies ++= Seq(
  // Commons
  "org.apache.httpcomponents" % "httpclient" % "4.2.5",
  "commons-io" % "commons-io" % "2.2",
  // JSON
  "org.json4s" %% "json4s-core" % "3.2.5",
  "org.json4s" %% "json4s-jackson" % "3.2.5",
  // Joda
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.4",
  // Logging
  "org.slf4j" % "slf4j-api" % "1.7.5"
)

// Version specific dependencies
libraryDependencies <++= (scalaVersion) { (v) =>
 val specs2 = v match {
    case "2.9.0" | "2.9.0-1" => "org.specs2" % "specs2_2.9.0" % "1.12.4" % "test"
    case "2.9.1" | "2.9.1-1" => "org.specs2" %% "specs2" % "1.12.4" % "test"
    case "2.9.2" | "2.9.3" => "org.specs2" %% "specs2" % "1.12.4.1" % "test"
    case v if v.startsWith("2.10") => "org.specs2" %% "specs2" % "2.1.1" % "test"
  }
  Seq(specs2)
}
