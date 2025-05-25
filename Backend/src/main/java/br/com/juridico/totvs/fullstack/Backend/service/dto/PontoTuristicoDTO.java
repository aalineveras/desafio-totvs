package br.com.juridico.totvs.fullstack.Backend.service.dto;


import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;

public class PontoTuristicoDTO {

    private Long id;
    private String nome;
    private String pais;
    private String cidade;
    private String estacao;
    private String resumo;

    public PontoTuristicoDTO(PontoTuristico entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.pais = entidade.getPais();
        this.cidade = entidade.getCidade();
        this.estacao = entidade.getEstacao();
        this.resumo = entidade.getResumo();
    }

    // Getters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getPais() { return pais; }
    public String getCidade() { return cidade; }
    public String getEstacao() { return estacao; }
    public String getResumo() { return resumo; }
}
