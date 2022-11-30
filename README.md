# Spring Boot Examples

_(in reversed order)_

* [p02springapplication](p02springapplication)
    * Using instance of the SpringApplication class
        * preconditions: 
            * make additional application properties file
            * use `spring.config.import` to point to this file
        * set property `spring.config.on-not-found=ignore` in SpringApplication instance
    * Using @PropertySource to load configurations
        * annotate configuration bean with `@PropertySource("classpath:some-config.properties")`
        * autowire `Environment` and get specific properties: `env.getProperty("prop-name")`
    * Changing the name of configuration file
        * create other config file in resources folder, e.g. `sbip.properties`
        * use `spring.config.name=<config-name>` parameter to switch to other config
            * example: `java -jar -Dspring.config.name=sbip p02springapplication-0.0.1-SNAPSHOT.jar`
        * or use `spring.config.location` property to specify a custom location
        * these properties are loaded in the early phases of startup, before the standard application.properties,
        so to configure them you can:
            * use `SpringApplication.setDefaultProperties()` method
            * use environment variables
            * use command-line arguments
