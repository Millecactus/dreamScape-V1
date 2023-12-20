package com.example.User;

import com.example.User.client.DreamClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public UserDto save(UserDto userDto);
    public List<UserDto> findAll();


    public UserDto saveUser(UserDto userDto);

//    public ResponseEntity<List<DreamDTO>> findAllDreamByUser(Integer userId);
}
