import sbt.Keys._
import sbt._
import org.sbtidea.SbtIdeaPlugin.ideaExtraTestConfigurations

object Testing {
  lazy val testAll = TaskKey[Unit]("test-all")

  import Configs._

  private lazy val testSettings = Seq(
    fork in Test := false,
    parallelExecution in Test := false
  )

  private lazy val integrationSettings =
    inConfig(IntegrationTest)(Defaults.testSettings) ++
      Seq(
        fork in IntegrationTest := false,
        parallelExecution in IntegrationTest := false,
        scalaSource in IntegrationTest := baseDirectory.value / "src/integration/scala")

  private lazy val e2eSettings =
    inConfig(EndToEndTest)(Defaults.testSettings) ++
      Seq(
        fork in EndToEndTest := false,
        parallelExecution in EndToEndTest := false,
        scalaSource in EndToEndTest := baseDirectory.value / "src/e2e/scala")

  lazy val settings = testSettings ++ integrationSettings ++ e2eSettings ++ Seq(
    testAll :=(),
    testAll <<= testAll.dependsOn(test in EndToEndTest),
    testAll <<= testAll.dependsOn(test in IntegrationTest),
    testAll <<= testAll.dependsOn(test in Test),
    ideaExtraTestConfigurations := Configs.all
  )
}