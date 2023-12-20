package com.dreamscape.app;

import com.example.User.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DreamService {

    public DreamDTO save (DreamDTO dreamDTO);

    public List<DreamDTO> findAll ();

    public ResponseEntity<List<DreamDTO>> findAllDreamByUser(Integer userId);

    public UserDto save(UserDto userDto);
}
