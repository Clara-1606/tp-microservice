package com.example.springquotestpgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication

public class ServiceDiscovery {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscovery.class, args);
    }
}
