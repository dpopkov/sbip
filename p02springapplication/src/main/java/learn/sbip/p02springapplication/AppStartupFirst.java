package learn.sbip.p02springapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class AppStartupFirst implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(AppStartupFirst.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("AppStartupFirst executed as a Spring Component");
    }
}
