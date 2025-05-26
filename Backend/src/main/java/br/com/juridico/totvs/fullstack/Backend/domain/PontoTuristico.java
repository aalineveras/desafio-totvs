package br.com.juridico.totvs.fullstack.Backend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class PontoTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String pais;
    private String cidade;
    private String estacao;
    private String resumo;

    @OneToMany(mappedBy = "pontoTuristico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

    public PontoTuristico() {}

    public PontoTuristico(Long id, String nome, String pais, String cidade, String estacao, String resumo) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.cidade = cidade;
        this.estacao = estacao;
        this.resumo = resumo;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
