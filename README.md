# Spring Boot Examples

* [Project: p02springapplication](#project-p02springapplication)
    * [Managing Configurations](#managing-configurations)
    * [Defining custom properties](#defining-custom-properties)
    * [Executing code on Spring Boot application startup](#executing-code-on-spring-boot-application-startup)
    * [Validate user data using Bean Validation](#validate-user-data-using-bean-validation)

_(projects in reversed order)_

### [Project: p02springapplication](p02springapplication)
  
#### Managing Configurations  
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
* Using OS environment variables
    * set environment variable:
        * in Windows: `<VAR>=<value>`
        * in Linux: `export <VAR>=<value>`
        * or use IDE capabilities
    * reference the environment variable in configuration file
        * example: `app.timeout=${APP_TIMEOUT}`
    * access in code: `environment.getProperty("app.timeout")`
* Properties order precedence from lower to higher:
    * SpringApplication - in code
    * @PropertySource - in code
    * Config data file - in files
    * OS environment variable - in files+shell
    * Command line arguments - in shell

#### Defining custom properties
* Defining custom properties with `@ConfigurationProperties` in a Spring Boot application
    * Add dependency to Spring Boot configuration processor to generate metadata about annotated classes:
    ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
    ```
    * Add custom properties
    * Create class containing properties and annotated `@ConfigurationProperties`
    ```java
    @ConstructorBinding
    @ConfigurationProperties(prefix = "app.sbip.ct")
    public class AppProperties {
      //...
    }
    ```
    * Add `@EnableConfigurationProperties({AppProperties.class})` to ensure registering
    ```java
    @SpringBootApplication
    @EnableConfigurationProperties({AppProperties.class})
    public class P02springApplication {
      //...
    }
    ```
    * Do `mvn clean package` and enjoy auto-completion and quick access to documentation in application.properties file

#### Executing code on Spring Boot application startup
* Using `CommandLineRunner` to execute code at Spring Boot application startup
```java
@Order(1)
@Component
public class AppStartup implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("AppStartup executed as a Spring Component");
    }
}
```

#### Validate user data using Bean Validation
* Add dependency for validation:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
* Use annotations: `@NotBlank`, `@NotEmpty`, `@NotNull`, `@Min`, `@Max`, `@Pattern`, `@Size`, `@Email`
* Use `javax.validation.Validator`:
```java
Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
Set<ConstraintViolation<Course>> violations = validator.validate(course);
violations.forEach(v -> log.error("A constraint violation has occurred: {}", v.getMessage()));
```


[Top](#spring-boot-examples)
