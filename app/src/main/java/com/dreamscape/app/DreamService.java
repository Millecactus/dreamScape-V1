package com.dreamscape.app;

import java.util.List;

public interface DreamService {

    public DreamDTO save (DreamDTO dreamDTO);

    public List<DreamDTO> findAll ();
}
