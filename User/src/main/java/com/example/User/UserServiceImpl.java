package com.example.User;

import com.example.User.client.DreamClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter

public class UserServiceImpl implements UserService{

    private  final UserRepository userRepository;

    private final DreamClient client;
    @Override
    public UserDto save(UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDto saveUser(UserDto userDto) {

            return userRepository.save(userDto);
    }

//    @Override
//    public ResponseEntity <List<DreamDTO>> findAllDreamByUser(Integer userId) {
//
//        System.out.print("coucou");
//
////        var user = userRepository.findById(userId)
////                        .orElse(UserDto.builder()
////                                .firstname("NOT FOUND")
////                                .lastname("NOT FOUND")
////                                .email("NOT FOUND")
////                                .build()
////                        );
////
////        var dream = findAllDreamByUser(user.getUserId());
////        return ResponseEntity.ok(List.of(
////                DreamDTO.builder()
////                        .title("titre")
////                        .description("desc")
////                        .build())
////        );
////
////        var dream = userRepository.findAll()
//        return null;
//    }


}
