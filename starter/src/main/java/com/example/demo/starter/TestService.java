package com.example.demo.starter;

import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusScrapeEndpoint;
import org.springframework.scheduling.annotation.Scheduled;


public class TestService {
    private TestProperties testProperties;
    private PrometheusScrapeEndpoint prometheusScrapeEndpoint;
    public TestService(TestProperties testProperties, PrometheusScrapeEndpoint prometheusScrapeEndpoint) {
        this.testProperties = testProperties;
        this.prometheusScrapeEndpoint = prometheusScrapeEndpoint;
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void test() {
        System.out.println(testProperties.getName() + "_test_" + testProperties.getAge());
        System.out.println(prometheusScrapeEndpoint.scrape());
    }

}
