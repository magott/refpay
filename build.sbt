enablePlugins(JettyPlugin)

name:="dommer-fiks"

scalaVersion:="2.11.7"

scalacOptions += "-target:jvm-1.8"

organization := "com.andersen-gott"

libraryDependencies ++=
  Seq(
    "net.databinder" %% "unfiltered" % "0.8.4",
    "net.databinder" %% "unfiltered-filter" % "0.8.4",
    "net.databinder" %% "unfiltered-jetty" % "0.8.4",
    "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
    "io.argonaut" %% "argonaut" % "6.0.4",
    "org.slf4j" % "slf4j-simple" % "1.6.4",
    "org.jsoup" % "jsoup" % "1.8.3",
    "org.scalatest" %% "scalatest" % "2.2.1" % "test",
    "bouncycastle" % "bcprov-jdk16" % "140",
    "org.jasypt" % "jasypt" % "1.9.0",
    "org.constretto" %% "constretto-scala" % "1.1",
    "org.apache.poi" % "poi-ooxml" % "3.14",
    "com.zaxxer" % "HikariCP" % "2.4.5",
    "org.flywaydb" % "flyway-core" % "4.0",
    "org.hsqldb" % "hsqldb" % "2.3.3",
    "org.postgresql" % "postgresql" % "9.4.1208.jre7",
    "com.itextpdf" % "itextpdf" % "5.5.9"
  )