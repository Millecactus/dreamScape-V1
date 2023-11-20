package com.example.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter

public class UserServiceImpl implements UserService{

    private  final UserRepository userRepository;
    @Override
    public UserDto save(UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll();
    }
}
