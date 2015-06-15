import sbt._

object Configs {
  val EndToEndTest = config("e2e") extend (Runtime)
  val IntegrationTest = config("integration") extend (Runtime)
  val all = Seq(IntegrationTest, EndToEndTest)

}