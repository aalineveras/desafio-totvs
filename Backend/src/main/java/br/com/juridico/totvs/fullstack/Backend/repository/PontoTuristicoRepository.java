package br.com.juridico.totvs.fullstack.Backend.repository;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoTuristicoRepository extends JpaRepository<PontoTuristico, Long> {
}
