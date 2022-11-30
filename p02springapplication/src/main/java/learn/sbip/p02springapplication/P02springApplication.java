package learn.sbip.p02springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class P02springApplication {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("spring.config.on-not-found", "ignore");

        SpringApplication application = new SpringApplication(P02springApplication.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.setDefaultProperties(properties);
        application.run();
    }

}
