// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See https://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name := "Wabase Template",
    scalaVersion := "3.8.4",
    // ScriptedPlugin is enabled for scripted task keys; overrides below must stay in
    // build.sbt so they win over ScriptedPlugin defaults (which skip Test/g8).
    sbtTestDirectory := target.value / "sbt-test",
    scriptedBufferLog := false,
    scriptedDependencies := Def.uncached {
      val log = streams.value.log
      log.info("g8Test: applying template from src/main/g8 ...")
      (Test / g8).value
      log.info(s"g8Test: template ready at ${(Test / g8 / target).value}")
      log.info("g8Test: running scripted test ...")
      ()
    },
    Test / g8Test := Def.uncached(scripted.evaluated),
    scriptedLaunchOpts ++= List(
      "--add-opens=java.base/java.util=ALL-UNNAMED",
      "--add-opens=java.base/java.lang=ALL-UNNAMED",
      "-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-Xss2m", "-Dfile.encoding=UTF-8",
      "-DHOST=http://localhost:8082", "-DPORT=8082", "-DAPP_HOME=./app-home-example",
      "-DMAIN_DB_URL=jdbc:hsqldb:mem:mymemdb", "-DMAIN_DB_USER=SA", "-DMAIN_DB_PWD=",
      "-DAUDIT_DB_URL=jdbc:hsqldb:mem:mymemdb", "-DAUDIT_DB_USER=SA", "-DAUDIT_DB_PWD=",
    ),
  )
