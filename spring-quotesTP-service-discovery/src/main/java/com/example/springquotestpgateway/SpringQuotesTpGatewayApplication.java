package com.example.springquotestpgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class SpringQuotesTpGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringQuotesTpGatewayApplication.class, args);
    }

}
