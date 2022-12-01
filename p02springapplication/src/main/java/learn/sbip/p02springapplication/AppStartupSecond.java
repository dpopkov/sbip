package learn.sbip.p02springapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class AppStartupSecond implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(AppStartupSecond.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("AppStartupSecond executed as a Spring Component");
    }
}
