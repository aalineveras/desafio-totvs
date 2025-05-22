package br.com.juridico.totvs.fullstack.Backend.controller;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.service.PontoTuristicoService;
import br.com.juridico.totvs.fullstack.Backend.service.PontoTuristicoServiceImpl;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController()
@RequestMapping("/ponto-turistico")
public class PontoTuristicoController {
    private final PontoTuristicoService PontoTuristicoService;

    public PontoTuristicoController(PontoTuristicoService PontoTuristicoService){
        this.PontoTuristicoService = PontoTuristicoService;
    }

     @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PontoTuristicoDTO create(@RequestBody PontoTuristicoCreateUpdateDTO dto) {
        return PontoTuristicoService.create(dto);
    }

    @GetMapping
    public List<PontoTuristicoDTO> getAll() {
        return PontoTuristicoService.getAll();
    }

    @GetMapping("{id}")
    public PontoTuristicoDTO getById(@PathVariable Long id) {
        return PontoTuristicoService.getById(id);
    }

    @PutMapping("{id}")
    public PontoTuristicoDTO update(@PathVariable Long id, @RequestBody PontoTuristicoCreateUpdateDTO dto) {
        return PontoTuristicoService.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        PontoTuristicoService.delete(id);
    }
}
