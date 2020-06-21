package com.wzz.wuzezhouspringcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WuzezhouSpringCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuzezhouSpringCloudGatewayApplication.class, args);
    }

}
