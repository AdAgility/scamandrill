import sbtrelease.{ReleasePlugin, Version => ReleaseVersion}

lazy val releaseSettings = ReleasePlugin.releaseSettings ++ Seq(
  ReleaseKeys.versionBump := ReleaseVersion.Bump.Minor
)

lazy val commonBuildSettings = Seq (
  organization := "com.adagility",

  scalaVersion := "2.11.6",

  scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-feature",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-encoding", "UTF-8",
    "-target:jvm-1.8"),

  publishArtifact in (Compile, packageDoc) := false,
  publishArtifact in (Compile, packageSrc) := true

  // put a publishTo in your local global.sbt file
)

lazy val root = (project in file(".")).
  settings(commonBuildSettings: _*).
  settings(
    name:= "scamandrill",
    libraryDependencies ++= {
      val akkaV = "2.3.4"
      val sprayV = "1.3.2"
      Seq(
        "io.spray"          %% "spray-can"        % sprayV,
        "io.spray"          %% "spray-routing"    % sprayV,
        "io.spray"          %% "spray-json"       % "1.3.1",
        "io.spray"          %%"spray-client"      % sprayV,
        "com.typesafe.akka" %% "akka-actor"       % akkaV,
        "com.typesafe"      % "config"            % "1.2.1",
        "ch.qos.logback"    % "logback-classic"   % "1.0.6"
      ) ++ Seq(
        "org.specs2"        %%  "specs2"          % "2.3.13"    % "test",
        "org.scalatest"     %%  "scalatest"       % "2.1.6"     % "test->*",
        "io.spray"          %% "spray-testkit"    % sprayV      % "test",
        "com.typesafe.akka" %% "akka-testkit"     % akkaV       % "test"
      )
    },
    resolvers ++= Seq("spray repo" at "http://repo.spray.io/"),
    parallelExecution in Test := true
  )
