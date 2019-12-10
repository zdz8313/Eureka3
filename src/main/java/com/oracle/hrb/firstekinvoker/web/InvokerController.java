package com.oracle.hrb.firstekinvoker.web;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/invoker")
//加上Configuration变成配置文件
@Configuration
public class InvokerController {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
    @GetMapping
    public  Object  doSomething(){
      RestTemplate rt = getRestTemplate();
    String json =   rt.getForObject("http://first-service-provoider/user",String.class);
        System.out.println( "执行了doSonthing 。。。。。");
        System.out.println(json);
     return  json;
    }
}
