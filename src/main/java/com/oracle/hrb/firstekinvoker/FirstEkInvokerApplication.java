package com.oracle.hrb.firstekinvoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FirstEkInvokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstEkInvokerApplication.class, args);
    }

}
