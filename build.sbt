//enablePlugins(JettyPlugin)

name:="dommerbetaling"

scalaVersion:="2.12.6"
scalacOptions += "-Ypartial-unification"
lazy val doobieVersion = "0.6.0"


version := "1.0"

organization := "com.andersen-gott"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
libraryDependencies ++=
  Seq(
//    "net.databinder" %% "unfiltered" % "0.8.4",
//    "net.databinder" %% "unfiltered-filter" % "0.8.4",
//    "net.databinder" %% "unfiltered-jetty" % "0.8.4",
//    "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
    "org.slf4j" % "slf4j-simple" % "1.6.4",
    "org.jsoup" % "jsoup" % "1.8.3",
    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.apache.poi" % "poi-ooxml" % "3.14",
    "com.zaxxer" % "HikariCP" % "2.4.5",
    "org.liquibase" % "liquibase-core" % "3.5.3",
//    "org.hsqldb" % "hsqldb" % "2.3.4",
    "com.h2database" % "h2" % "1.4.195",
    "org.postgresql" % "postgresql" % "9.4.1211",
    "org.tpolecat" %% "doobie-core"       % doobieVersion,
    "org.tpolecat" %% "doobie-postgres"   % doobieVersion,
    "org.tpolecat" %% "doobie-hikari"   % doobieVersion
//    "org.tpolecat" %% "doobie-specs2"     % doobieVersion
  )