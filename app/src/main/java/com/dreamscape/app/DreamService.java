package com.dreamscape.app;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DreamService {

    public DreamDTO save (DreamDTO dreamDTO);

    public List<DreamDTO> findAll ();

    public ResponseEntity<List<DreamDTO>> findDreamByUser(Integer userId);
}
