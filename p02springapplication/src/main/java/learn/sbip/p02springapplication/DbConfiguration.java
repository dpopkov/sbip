package learn.sbip.p02springapplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:dbconfig.properties")
public class DbConfiguration {

    private final Environment environment;

    public DbConfiguration(Environment environment) {
        this.environment = environment;
    }

    public String getUsername() {
        return environment.getProperty("username");
    }

    public String getPassword() {
        return environment.getProperty("password");
    }

    @Override
    public String toString() {
        return "DbConfiguration{"
                + "username=" + getUsername()
                + ", password=" + getPassword() +
                '}';
    }
}
