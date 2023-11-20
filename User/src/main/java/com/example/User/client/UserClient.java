package com.example.User.client;


import com.example.User.User;
import com.example.User.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="userService", url ="${application.config.user-url}")

public interface UserClient {

    @GetMapping("/user/{userId}")
    List <User> findAllUserByDream(@PathVariable  ("userId") Integer userId);


}
