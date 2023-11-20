package com.example.User;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping(value ="/saveUser")
    public User save( @RequestBody UserDto userDto){
        return (userDto.toEntity(userService.save(userDto)));
    }

    @GetMapping(value ="/findAll")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

}
