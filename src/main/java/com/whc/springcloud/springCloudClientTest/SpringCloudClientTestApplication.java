package com.whc.springcloud.springCloudClientTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudClientTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientTestApplication.class, args);
    }

}
