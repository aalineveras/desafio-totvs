package br.com.juridico.totvs.fullstack.Backend.service.dto;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import java.time.LocalDateTime;

public class ComentarioDTO {

    private String autor;
    private String texto;
    private LocalDateTime data;
    private Long pontoTuristicoId;

    public ComentarioDTO() {
    }

    public ComentarioDTO(String autor, String texto, LocalDateTime data, Long pontoTuristicoId) {
        this.autor = autor;
        this.texto = texto;
        this.data = data;
        this.pontoTuristicoId = pontoTuristicoId;
    }

    public ComentarioDTO(Comentario comentario) {
        this.autor = comentario.getAutor();
        this.texto = comentario.getTexto();
        this.data = comentario.getData();
        if (comentario.getPontoTuristico() != null) {
            this.pontoTuristicoId = comentario.getPontoTuristico().getId();
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Long getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public void setPontoTuristicoId(Long pontoTuristicoId) {
        this.pontoTuristicoId = pontoTuristicoId;
    }
}
