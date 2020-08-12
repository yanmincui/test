package com.example.demo.starter;

import org.springframework.boot.actuate.autoconfigure.metrics.export.prometheus.PrometheusMetricsExportAutoConfiguration;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusScrapeEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableConfigurationProperties(TestProperties.class)
@AutoConfigureAfter(PrometheusMetricsExportAutoConfiguration.PrometheusScrapeEndpointConfiguration.class)
public class AutoConfig {

    @Bean
    @ConditionalOnMissingBean(TestService.class)
    TestService testService(TestProperties testProperties, PrometheusScrapeEndpoint prometheusScrapeEndpoint) {
        return new TestService(testProperties, prometheusScrapeEndpoint);
    }
}
