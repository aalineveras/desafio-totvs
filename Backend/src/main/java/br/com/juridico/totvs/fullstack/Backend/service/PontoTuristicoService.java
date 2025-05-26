package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;

import java.util.List;
import java.util.Optional;

public interface PontoTuristicoService {

    List<PontoTuristico> listarTodos();

    Optional<PontoTuristico> buscarPorId(Long id);

    PontoTuristico salvar(PontoTuristico ponto);

    void excluir(Long id);

    List<PontoTuristico> buscarPorTermo(String termo);

    List<PontoTuristico> buscarComFiltros(String search, String pais, String cidade, String estacao);
}

