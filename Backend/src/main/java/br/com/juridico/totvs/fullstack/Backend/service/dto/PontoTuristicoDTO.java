package br.com.juridico.totvs.fullstack.Backend.service.dto;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;

public class PontoTuristicoDTO {

    private Long id;
    private String nome;
    private String cidade;
    private String melhorEstacao;
    private String resumo;
    private Long paisId;

    public PontoTuristicoDTO(PontoTuristico entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cidade = entity.getCidade();
        this.melhorEstacao = entity.getMelhorEstacao();
        this.resumo = entity.getResumo();
        this.paisId = entity.getPais().getId();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCidade() { return cidade; }
    public String getMelhorEstacao() { return melhorEstacao; }
    public String getResumo() { return resumo; }
    public Long getPaisId() { return paisId; }
}
