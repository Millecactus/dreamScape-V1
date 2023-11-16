package com.dreamscape.app;

import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/dreamscape")
@RequiredArgsConstructor
@RestController
public class DreamController {

    private final DreamServiceImpl service;

    @PostMapping (value ="/saveDream")
    public ResponseEntity<DreamDTO> save(@RequestBody DreamDTO dreamDTO){
        Optional <DreamDTO> savedDreamOptional= Optional.ofNullable(service.save(dreamDTO));
        return savedDreamOptional.
                map(savedDream -> ResponseEntity.ok().body(savedDream))
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping(value = "/findAll")
    public List<DreamDTO> findAll(){
        return  service.findAll();
    }

}
