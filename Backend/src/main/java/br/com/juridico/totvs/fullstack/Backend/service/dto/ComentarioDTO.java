package br.com.juridico.totvs.fullstack.Backend.service.dto;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import java.time.LocalDateTime;

public class ComentarioDTO {
    private Long id;
    private String autor;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Long pontoTuristicoId;

    public ComentarioDTO(Comentario comentario) {
        this.id = comentario.getId();
        this.autor = comentario.getAutor();
        this.mensagem = comentario.getMensagem();
        this.dataCriacao = comentario.getDataCriacao();
        this.pontoTuristicoId = comentario.getPontoTuristicoId();
    }

    // Getters
    public Long getId() { return id; }
    public String getAutor() { return autor; }
    public String getMensagem() { return mensagem; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public Long getPontoTuristicoId() { return pontoTuristicoId; }
}
