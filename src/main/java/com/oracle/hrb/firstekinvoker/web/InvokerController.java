package com.oracle.hrb.firstekinvoker.web;

import com.oracle.hrb.firstekinvoker.bean.User;
import com.oracle.hrb.firstekinvoker.client.UserClient;

import com.oracle.hrb.firstekinvoker.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserClient userClient;
    //@!
    @Autowired
    private RestTemplateService rtService;

    @GetMapping
    public  Object  doSomething(){
//      RestTemplate rt = getRestTemplate();
//    String json =   rt.getForObject("http://first-service-provoider/user",String.class);
//        System.out.println( "执行了doSonthing 。。。。。");
//        System.out.println(json);
//     return  json;
        //@!
      //下面两个都可以，代表两种方法
      //return rtService.getUser();
      return userClient.getUser();
    }

    @GetMapping("/addUser")
    public  String addUser(){
        User user =new User();
        user.setName("猫腻");
        user.setPassword("maoni");
        return  userClient.addUser(user);
    }


}
