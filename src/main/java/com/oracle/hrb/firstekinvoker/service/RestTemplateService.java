package com.oracle.hrb.firstekinvoker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.oracle.hrb.firstekinvoker.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//@!  全是添加熔断器操作的
@Service
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    //加一个熔断机制的注解（超时后执行的方法）
    @HystrixCommand(fallbackMethod = "getFallback" , commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "11000")})
    public User getUser(){
     User user = restTemplate.getForObject("http://first-service-provoider/user",User.class,1);
     return  user;
    }

    public  User getFallback(){
        System.out.println("超时回退");
        User user =new User();
        user.setName("超时警报");
        user.setPassword("123456");
        user.setMsg("超时回退。。。。");
        return user;
   }
}
