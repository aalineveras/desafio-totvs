package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.repository.PontoTuristicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoTuristicoServiceImpl implements PontoTuristicoService {

    private final PontoTuristicoRepository repository;

    public PontoTuristicoServiceImpl(PontoTuristicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PontoTuristico> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<PontoTuristico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public PontoTuristico salvar(PontoTuristico ponto) {
        return repository.save(ponto);
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
