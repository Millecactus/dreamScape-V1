package com.example.User.client;

import com.example.User.DreamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DreamClient {

    @FeignClient(name="dream-service", url="${application.config.dream-url}")
    public interface UserClient {

        @GetMapping(value = "/user/{userId}")
        List <DreamDTO> findAllDreamByUser (@PathVariable ("userId") Integer userId);

    }

}
