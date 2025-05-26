package br.com.juridico.totvs.fullstack.Backend.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;
    private String texto;
    private LocalDateTime data;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ponto_turistico_id", nullable = false)
    private PontoTuristico pontoTuristico;

    public Comentario() {
    }

    public Comentario(String autor, String texto, LocalDateTime data, PontoTuristico pontoTuristico) {
        this.autor = autor;
        this.texto = texto;
        this.data = data;
        this.pontoTuristico = pontoTuristico;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PontoTuristico getPontoTuristico() {
        return pontoTuristico;
    }

    public void setPontoTuristico(PontoTuristico pontoTuristico) {
        this.pontoTuristico = pontoTuristico;
    }
}
