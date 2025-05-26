package br.com.juridico.totvs.fullstack.Backend.controller;

import br.com.juridico.totvs.fullstack.Backend.service.ComentarioServiceImpl;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
@CrossOrigin(origins = "*")
public class ComentarioController {

    @Autowired
    private ComentarioServiceImpl comentarioService;

    // ✅ Lista todos os comentários do sistema
    @GetMapping
    public List<ComentarioDTO> listarTodos() {
        return comentarioService.listarTodos();
    }

    // ✅ Lista comentários de um ponto turístico específico
    @GetMapping("/ponto/{id}")
    public List<ComentarioDTO> listarPorPonto(@PathVariable Long id) {
        return comentarioService.listarPorPonto(id);
    }

    // ✅ Cria novo comentário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioDTO criar(@RequestBody ComentarioDTO dto) {
        return comentarioService.salvarComentario(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarComentario(@PathVariable Long id) {
        comentarioService.deletarPorId(id);
    }

}
