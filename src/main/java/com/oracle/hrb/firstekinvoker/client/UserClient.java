package com.oracle.hrb.firstekinvoker.client;

import com.oracle.hrb.firstekinvoker.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(value = "first-service-provoider" , fallback = UserClient.UserClientFallback.class)
public interface UserClient {
  @GetMapping("/user")
    User getUser();
  @PostMapping("/user")
  String addUser(@RequestBody User user);


@Component
  static class  UserClientFallback implements  UserClient{

    public User getUser() {
      System.out.println("调用了回退函数");
      User user =new User();
      user.setName("userClient回退");
      user.setPassword("123456");
      user.setMsg("触发了Feign的熔断器");
      return user;
    }

    public String addUser(User user) {
      return null;
    }
  }

}
