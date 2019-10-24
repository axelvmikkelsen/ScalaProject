libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

resolvers += "Central" at "http://central.maven.org/maven2/"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-language:postfixOps")
