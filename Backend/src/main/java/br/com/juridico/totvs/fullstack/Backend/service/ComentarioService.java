package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioCreateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioService {
    ComentarioDTO create(ComentarioCreateDTO dto);
    List<ComentarioDTO> getAll();
    List<ComentarioDTO> getByPontoTuristicoId(Long pontoId);
    void delete(Long id);

    
}
