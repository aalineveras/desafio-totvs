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
        return repository.findAllByOrderByIdDesc(); // ✅ já retorna ordenado
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

    @Override
    public List<PontoTuristico> buscarPorTermo(String termo) {
        return repository.buscarPorTermo(termo);
    }

    @Override
    public List<PontoTuristico> buscarComFiltros(String search, String pais, String cidade, String estacao) {
        boolean semFiltros = (search == null || search.isEmpty()) &&
                             (pais == null || pais.isEmpty()) &&
                             (cidade == null || cidade.isEmpty()) &&
                             (estacao == null || estacao.isEmpty());

        if (semFiltros) {
            return repository.findAllByOrderByIdDesc(); // ✅ ordenado mais recente primeiro
        }

        // Filtro manual (mantido do seu código original)
        List<PontoTuristico> todos = repository.findAll();

        return todos.stream()
                .filter(p -> search == null || search.isEmpty() || (containsIgnoreCase(p.getNome(), search) ||
                        containsIgnoreCase(p.getPais(), search) ||
                        containsIgnoreCase(p.getCidade(), search) ||
                        containsIgnoreCase(p.getEstacao(), search)))
                .filter(p -> pais == null || (p.getPais() != null && p.getPais().equalsIgnoreCase(pais)))
                .filter(p -> cidade == null || (p.getCidade() != null && p.getCidade().equalsIgnoreCase(cidade)))
                .filter(p -> estacao == null || (p.getEstacao() != null && p.getEstacao().equalsIgnoreCase(estacao)))
                .sorted((a, b) -> Long.compare(b.getId(), a.getId())) // ✅ ordena por ID desc
                .toList();
    }

    private boolean containsIgnoreCase(String campo, String termo) {
        return campo != null && campo.toLowerCase().contains(termo.toLowerCase());
    }
}
