package learn.sbip.p02springapplication;

import org.springframework.stereotype.Service;

@Service
public class AppService {

    private final AppProperties appProperties;

    public AppService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public AppProperties getAppProperties() {
        return appProperties;
    }
}
