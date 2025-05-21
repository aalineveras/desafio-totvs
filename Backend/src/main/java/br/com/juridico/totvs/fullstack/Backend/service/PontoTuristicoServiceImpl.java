package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.domain.Pais;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PontoTuristicoServiceImpl implements PontoTuristicoService {

    List<PontoTuristico> listPontoTuristico = null;
    private final PaisService paisService;

    public PontoTuristicoServiceImpl(PaisService paisService) {
        this.paisService = paisService;
        this.listPontoTuristico = new ArrayList<>();
    }

    @Override
    public PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO dto) {
        PontoTuristico novo = new PontoTuristico();
        novo.setId(getNewId());
        copyDtoToEntity(dto, novo);
        this.listPontoTuristico.add(novo);
        return new PontoTuristicoDTO(novo);
    }

    @Override
    public PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO dto) {
        PontoTuristico entity = this.getEntityById(id);
        int index = this.listPontoTuristico.indexOf(entity);

        copyDtoToEntity(dto, entity);
        this.listPontoTuristico.set(index, entity);

        return new PontoTuristicoDTO(entity);
    }

    @Override
    public void delete(Long id) {
        PontoTuristico entity = this.getEntityById(id);
        this.listPontoTuristico.remove(entity);
    }

    @Override
    public PontoTuristicoDTO getById(Long id) {
        PontoTuristico entity = this.getEntityById(id);
        return new PontoTuristicoDTO(entity);
    }

    @Override
    public List<PontoTuristicoDTO> getAll() {
        return this.listPontoTuristico.stream()
                .map(PontoTuristicoDTO::new)
                .collect(Collectors.toList());
    }

    // Métodos auxiliares

    private Long getNewId() {
        if (this.listPontoTuristico.size() > 0) {
            return this.listPontoTuristico.stream()
                    .mapToLong(PontoTuristico::getId)
                    .max()
                    .orElse(0L) + 1;
        } else {
            return 1L;
        }
    }

    private PontoTuristico getEntityById(Long id) {
        return this.listPontoTuristico.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private void copyDtoToEntity(PontoTuristicoCreateUpdateDTO dto, PontoTuristico entity) {
        entity.setNome(dto.getNome());
        entity.setCidade(dto.getCidade());
        entity.setMelhorEstacao(dto.getMelhorEstacao());
        entity.setResumo(dto.getResumo());

        Pais pais = paisService.getEntityById(dto.getPaisId());
        entity.setPais(pais);
    }
}
