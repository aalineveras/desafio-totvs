package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.Pais;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PaisCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PaisDTO;

import java.util.List;

public interface PaisService {
    PaisDTO create(PaisCreateUpdateDTO dto);
    PaisDTO update(Long id, PaisCreateUpdateDTO dto);
    void delete(Long id);
    PaisDTO getPaisbyId(Long id);
    List<PaisDTO> getPaisByContinente(String continente);
    List<PaisDTO> getAllPais();

    // Adicione esta linha:
    Pais getEntityById(Long id);
}
