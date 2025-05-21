package br.com.juridico.totvs.fullstack.Backend.service.dto;

public class PontoTuristicoCreateUpdateDTO {

    private String nome;
    private String cidade;
    private String melhorEstacao;
    private String resumo;
    private Long paisId;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getMelhorEstacao() { return melhorEstacao; }
    public void setMelhorEstacao(String melhorEstacao) { this.melhorEstacao = melhorEstacao; }

    public String getResumo() { return resumo; }
    public void setResumo(String resumo) { this.resumo = resumo; }

    public Long getPaisId() { return paisId; }
    public void setPaisId(Long paisId) { this.paisId = paisId; }
}