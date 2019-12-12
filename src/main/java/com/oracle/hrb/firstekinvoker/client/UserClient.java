package com.oracle.hrb.firstekinvoker.client;

import com.oracle.hrb.firstekinvoker.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("first-service-provoider")
public interface UserClient {
  @GetMapping("/user")
    User getUser();
  @PostMapping("/user")
  String addUser(@RequestBody User user);
}
