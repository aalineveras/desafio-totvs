package br.com.juridico.totvs.fullstack.Backend.controller;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.PontoTuristicoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/ponto-turistico")
@CrossOrigin(origins = "*")
public class PontoTuristicoController {

    private final PontoTuristicoService service;

    public PontoTuristicoController(PontoTuristicoService service) {
        this.service = service;
    }

    // ✅ Listagem compatível com po-page-dynamic-table (com paginação e ordenação por ID desc)
    @GetMapping
    public Map<String, Object> listarComFiltros(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String pais,
            @RequestParam(required = false) String cidade,
            @RequestParam(required = false) String estacao) {

        List<PontoTuristico> todos = service.buscarComFiltros(search, pais, cidade, estacao);

        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, todos.size());

        List<PontoTuristico> pagina = fromIndex < todos.size()
                ? todos.subList(fromIndex, toIndex)
                : List.of();

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("items", pagina);
        resultado.put("hasNext", toIndex < todos.size());

        return resultado;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoTuristicoDTO> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ponto -> ResponseEntity.ok(new PontoTuristicoDTO(ponto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PontoTuristicoDTO> criar(@RequestBody PontoTuristicoCreateUpdateDTO dto) {
        PontoTuristico novo = dto.toEntity();
        PontoTuristico salvo = service.salvar(novo);
        return ResponseEntity.ok(new PontoTuristicoDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoTuristicoDTO> atualizar(@PathVariable Long id,
            @RequestBody PontoTuristicoCreateUpdateDTO dto) {
        return service.buscarPorId(id)
                .map(ponto -> {
                    dto.updateEntity(ponto);
                    PontoTuristico atualizado = service.salvar(ponto);
                    return ResponseEntity.ok(new PontoTuristicoDTO(atualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Optional<PontoTuristico> ponto = service.buscarPorId(id);
        if (ponto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
