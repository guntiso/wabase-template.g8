resolvers ++= Seq(
  "snapshots" at "https://central.sonatype.com/repository/maven-snapshots",
)

ThisBuild / libraryDependencySchemes += "org.mojoz" %% "querease" % VersionScheme.Always // TODO drop when sbt-mojoz depends on querease 11

libraryDependencies ++= Seq(
  "org.wabase" %% "wabase" % "9.0.0-SNAPSHOT",
)

addSbtPlugin("org.mojoz"          % "sbt-mojoz"     % "9.1.1")
addSbtPlugin("com.eed3si9n"       % "sbt-assembly"  % "2.5.0")
addSbtPlugin("nl.gn0s1s"          % "sbt-dotenv"    % "3.3.0")
addSbtPlugin("com.indoorvivants"  % "sbt-revolver"  % "0.11.2")
