package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.repository.ComentarioRepository;
import br.com.juridico.totvs.fullstack.Backend.repository.PontoTuristicoRepository;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PontoTuristicoRepository pontoRepository;

    // ✅ Lista todos os comentários do sistema
    public List<ComentarioDTO> listarTodos() {
        return comentarioRepository.findAll()
                .stream()
                .map(ComentarioDTO::new)
                .collect(Collectors.toList());
    }

    // ✅ Lista comentários de um ponto turístico, do mais novo para o mais antigo
    public List<ComentarioDTO> listarPorPonto(Long pontoId) {
        return comentarioRepository.findByPontoTuristicoIdOrderByDataDesc(pontoId)
                .stream()
                .map(ComentarioDTO::new)
                .collect(Collectors.toList());
    }

    // ✅ Salva um novo comentário
    public ComentarioDTO salvarComentario(ComentarioDTO dto) {
        PontoTuristico ponto = pontoRepository.findById(dto.getPontoTuristicoId())
                .orElseThrow(() -> new RuntimeException("Ponto turístico não encontrado"));

        Comentario comentario = new Comentario();
        comentario.setAutor(dto.getAutor());
        comentario.setTexto(dto.getTexto());
        comentario.setData(dto.getData() != null ? dto.getData() : LocalDateTime.now());
        comentario.setPontoTuristico(ponto);

        Comentario salvo = comentarioRepository.save(comentario);
        return new ComentarioDTO(salvo);
    }

    public void deletarPorId(Long id) {
        if (!comentarioRepository.existsById(id)) {
            throw new RuntimeException("Comentário não encontrado.");
        }
        comentarioRepository.deleteById(id);
    }

}
