resolvers ++= Seq(
  "snapshots" at "https://central.sonatype.com/repository/maven-snapshots",
)

libraryDependencies ++= Seq(
  "org.wabase" %% "wabase" % "8.0.0-RC57-SNAPSHOT",
)

addSbtPlugin("org.mojoz"          % "sbt-mojoz"     % "8.0.1")
addSbtPlugin("com.eed3si9n"       % "sbt-assembly"  % "2.3.1")
addSbtPlugin("nl.gn0s1s"          % "sbt-dotenv"    % "3.2.0")
addSbtPlugin("com.indoorvivants"  % "sbt-revolver"  % "0.11.2")
