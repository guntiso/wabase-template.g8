resolvers ++= Seq(
  "snapshots" at "https://central.sonatype.com/repository/maven-snapshots",
)

libraryDependencies ++= Seq(
  "org.wabase" %% "wabase" % "8.0.0-RC50-SNAPSHOT",
)

addSbtPlugin("org.mojoz"          % "sbt-mojoz"     % "7.1.0-SNAPSHOT")
addSbtPlugin("com.eed3si9n"       % "sbt-assembly"  % "2.3.1")
addSbtPlugin("nl.gn0s1s"          % "sbt-dotenv"    % "3.2.0")
addSbtPlugin("com.indoorvivants"  % "sbt-revolver"  % "0.11.2")
