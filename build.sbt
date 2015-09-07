
version := "1.0.0"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= {
  Seq(
  // 
  // Test
  //
  "com.novocode" % "junit-interface" % "0.11" % "test",
  // need for cucumber tests
  "info.cukes" % "cucumber-junit" % "1.2.0" % "test",
  "info.cukes" % "cucumber-java" % "1.2.0" % "test",  
  "info.cukes" %% "cucumber-scala" % "1.2.0" % "test",
  // need for scala test matchers
  "org.scalatest" %% "scalatest" % "2.2.3" % "test"
  )
}

parallelExecution in Test := false

