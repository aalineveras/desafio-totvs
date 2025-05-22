package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioCreateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final List<Comentario> comentarios = new ArrayList<>();

    @Override
    public ComentarioDTO create(ComentarioCreateDTO dto) {
        Comentario comentario = new Comentario();
        comentario.setId(getNewId());
        comentario.setAutor(dto.getAutor());
        comentario.setMensagem(dto.getMensagem());
        comentario.setPontoTuristicoId(dto.getPontoTuristicoId());
        comentario.setDataCriacao(LocalDateTime.now());

        comentarios.add(comentario);
        return new ComentarioDTO(comentario);
    }

    @Override
    public List<ComentarioDTO> getAll() {
        return comentarios.stream()
                .map(ComentarioDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioDTO> getByPontoTuristicoId(Long pontoId) {
        return comentarios.stream()
                .filter(c -> Objects.equals(c.getPontoTuristicoId(), pontoId))
                .map(ComentarioDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        comentarios.removeIf(c -> Objects.equals(c.getId(), id));
    }

    private Long getNewId() {
        return comentarios.stream()
                .mapToLong(Comentario::getId)
                .max()
                .orElse(0L) + 1;
    }
}
