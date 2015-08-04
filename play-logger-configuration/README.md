play-logger-configuration
=========================

Sample uses play in 2.4.x version

In order to use specific configuration file one need to pass it:

```sbt "start -Dconfig.resource=production.conf"```

Unfortunately in newest versions in Play it's impossible to specify logger configuration form within the *.conf file.

Instead one need to also pass the logger configuration location into run paramateres:

```sbt "start -Dlogger.resource=production-logback.xml"```