package br.com.juridico.totvs.fullstack.Backend.domain;

import java.time.LocalDateTime;

public class Comentario {
    private Long id;
    private String autor;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Long pontoTuristicoId;

    public Comentario() {}

    public Comentario(Long id, String autor, String mensagem, LocalDateTime dataCriacao, Long pontoTuristicoId) {
        this.id = id;
        this.autor = autor;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.pontoTuristicoId = pontoTuristicoId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public Long getPontoTuristicoId() { return pontoTuristicoId; }
    public void setPontoTuristicoId(Long pontoTuristicoId) { this.pontoTuristicoId = pontoTuristicoId; }
}
