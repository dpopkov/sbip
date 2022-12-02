package learn.sbip.p02springapplication;

import learn.sbip.p02springapplication.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Order(1)
@Component
public class AppStartupFirst implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(AppStartupFirst.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("AppStartupFirst executed as a Spring Component");
        Course course = new Course();
        course.setId(1L);
        course.setRating(0);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Course>> violations = validator.validate(course);
        violations.forEach(v -> log.error("A constraint violation has occurred. Violation details: [{}]", v));
    }
}
