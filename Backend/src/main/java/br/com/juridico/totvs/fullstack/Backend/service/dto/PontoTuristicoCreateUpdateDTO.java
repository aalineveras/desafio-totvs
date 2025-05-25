package br.com.juridico.totvs.fullstack.Backend.service.dto;


import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;

public class PontoTuristicoCreateUpdateDTO {

    private String nome;
    private String pais;
    private String cidade;
    private String estacao;
    private String resumo;

    public PontoTuristico toEntity() {
        return new PontoTuristico(null, nome, pais, cidade, estacao, resumo);
    }

    public void updateEntity(PontoTuristico entidade) {
        entidade.setNome(nome);
        entidade.setPais(pais);
        entidade.setCidade(cidade);
        entidade.setEstacao(estacao);
        entidade.setResumo(resumo);
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstacao() { return estacao; }
    public void setEstacao(String estacao) { this.estacao = estacao; }

    public String getResumo() { return resumo; }
    public void setResumo(String resumo) { this.resumo = resumo; }
}
