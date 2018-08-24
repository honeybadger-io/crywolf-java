# Run Play 2 Sample App

Edit your play-2/conf/application.properties, remove the comment mark from the honeybadger.api_key line,
then replace [YOURKEY] with your HoneyBadger API key.

honeybadger.api_key = [YOURKEY]

Please don't add this file to any of your pull requests, as you'll expose your private API key if you do.

At a minimum, in order to run the example, you'll need to install SBT.
[Download and install SBT instructions](https://www.scala-sbt.org/download.html)

You may need to follow these instructions as well:

* [Play 2.6 installation instructions](https://www.playframework.com/documentation/2.6.x/Installing)
* [Detailed notes for setting up SBT](https://www.scala-sbt.org/release/docs/Setup-Notes.html)


```
cd play-2
sbt run
```

Assuming default configuration, open `localhost:9000` to view the sample app in your browser.