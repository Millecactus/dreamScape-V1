package com.dreamscape.app;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DreamServiceImpl implements DreamService{

    private final DreamRepository dreamRepository;

    @Override
    public DreamDTO save(DreamDTO dreamDTO) {
        return dreamRepository.save(dreamDTO);
    }

    @Override
    public List<DreamDTO> findAll() {
        return dreamRepository.findAll();
    }

    @Override
    public ResponseEntity<List<DreamDTO>> findAllDreamByUser(Integer userId) {
//        return ResponseEntity.ok (dreamRepository.findDreamByUserId(userId));
        System.out.print("coucou");
        return null;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }


}
