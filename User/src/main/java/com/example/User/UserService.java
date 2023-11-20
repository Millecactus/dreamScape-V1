package com.example.User;

import java.util.List;

public interface UserService {
    public UserDto save(UserDto userDto);
    public List<UserDto> findAll();
}
