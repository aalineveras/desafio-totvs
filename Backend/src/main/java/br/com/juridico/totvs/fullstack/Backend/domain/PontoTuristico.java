package br.com.juridico.totvs.fullstack.Backend.domain;

public class PontoTuristico {

    private Long id;
    private String nome;
    private String cidade;
    private String melhorEstacao;
    private String resumo;
    private Pais pais;

    public PontoTuristico() {}

    public PontoTuristico(Long id, String nome, String cidade, String melhorEstacao, String resumo, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.melhorEstacao = melhorEstacao;
        this.resumo = resumo;
        this.pais = pais;
    }

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMelhorEstacao() {
        return melhorEstacao;
    }

    public void setMelhorEstacao(String melhorEstacao) {
        this.melhorEstacao = melhorEstacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
