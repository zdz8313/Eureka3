package com.oracle.hrb.firstekinvoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@！
//熔断器
@EnableCircuitBreaker
public class FirstEkInvokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstEkInvokerApplication.class, args);
    }

}
