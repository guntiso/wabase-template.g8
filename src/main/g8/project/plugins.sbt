resolvers ++= Seq(
  "snapshots" at "https://central.sonatype.com/repository/maven-snapshots",
)

libraryDependencies ++= Seq(
  "org.wabase" %% "wabase" % "8.0.0-RC49-SNAPSHOT" exclude(
    "org.scala-lang.modules", "scala-parser-combinators_2.12"), // version conflict fix for plugin
)

addSbtPlugin(("org.mojoz"    % "sbt-mojoz"     % "7.0.0").exclude (
  "org.mojoz", "querease_2.12",
))
addSbtPlugin("com.eed3si9n" % "sbt-assembly"  % "2.1.1")
addSbtPlugin("nl.gn0s1s"    % "sbt-dotenv"    % "3.2.0")
addSbtPlugin("io.spray"     % "sbt-revolver"  % "0.10.0")
