package br.com.juridico.totvs.fullstack.Backend.controller;

import br.com.juridico.totvs.fullstack.Backend.service.ComentarioService;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioCreateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioDTO create(@RequestBody ComentarioCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ComentarioDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/ponto/{pontoId}")
    public List<ComentarioDTO> getByPonto(@PathVariable Long pontoId) {
        return service.getByPontoTuristicoId(pontoId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
