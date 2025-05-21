package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;

import java.util.List;

public interface PontoTuristicoService {
    PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO dto);
    List<PontoTuristicoDTO> getAll();
    PontoTuristicoDTO getById(Long id);
    PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO dto);
    void delete(Long id);
}
