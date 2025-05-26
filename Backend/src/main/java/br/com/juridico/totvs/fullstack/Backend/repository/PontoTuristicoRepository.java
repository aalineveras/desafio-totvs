package br.com.juridico.totvs.fullstack.Backend.repository;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontoTuristicoRepository extends JpaRepository<PontoTuristico, Long> {

    List<PontoTuristico> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT p FROM PontoTuristico p WHERE " +
           "LOWER(p.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
           "LOWER(p.pais) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
           "LOWER(p.cidade) LIKE LOWER(CONCAT('%', :termo, '%')) OR " +
           "LOWER(p.estacao) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<PontoTuristico> buscarPorTermo(@Param("termo") String termo);

    // ✅ Este é o novo método que você precisa para ordenar pelo ID decrescente
    List<PontoTuristico> findAllByOrderByIdDesc();
}
