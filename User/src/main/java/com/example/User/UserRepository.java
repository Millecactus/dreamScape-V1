package com.example.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository <UserDto, Integer> {
    public UserDto save(UserDto userDto);
    public List<UserDto> findAll();

}
