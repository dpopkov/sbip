package learn.sbip.p02springapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Properties;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class})
public class P02springApplication {

    private static final Logger log = LoggerFactory.getLogger(P02springApplication.class);

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("spring.config.on-not-found", "ignore");

        SpringApplication application = new SpringApplication(P02springApplication.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.setDefaultProperties(properties);
        ConfigurableApplicationContext context = application.run();
        DbConfiguration dbConfig = context.getBean(DbConfiguration.class);
        log.info(dbConfig.toString());

        Environment environment = context.getBean(Environment.class);
        String appTimeout = environment.getProperty("app.timeout");
        log.info("appTimeout = {}", appTimeout);

        AppService appService = context.getBean(AppService.class);
        log.info("Application Properties = {}", appService.getAppProperties());
    }

}
