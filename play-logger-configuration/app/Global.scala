import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started " + Play.current.configuration.getString("application.name"))
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown..." + Play.current.configuration.getString("application.name"))
  }

}