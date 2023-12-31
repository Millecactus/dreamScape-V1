package com.dreamscape.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DreamRepository extends JpaRepository<DreamDTO, Integer> {

    public UserDto save(UserDto userdto);

    public List <DreamDTO> findDreamByUserId(Integer userId);

}