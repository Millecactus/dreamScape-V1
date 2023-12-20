package com.dreamscape.app.client;

import com.dreamscape.app.DreamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DreamClient {

    @FeignClient(name="UserService", url ="${application.config.user-url}")

    public interface UserClient {
        @GetMapping("/user/{userId}")
        List<DreamDTO> findAllDreamByUser(@PathVariable("userId") Integer userId);
    }

}



