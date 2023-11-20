package com.dreamscape.app;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DreamServiceImpl implements DreamService{

    private final DreamRepository repository;
    @Override
    public DreamDTO save(DreamDTO dreamDTO) {
        return repository.save(dreamDTO);
    }

    @Override
    public List<DreamDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity <List<DreamDTO>> findDreamByUser(Integer userId) {
        return null;
    }


}
