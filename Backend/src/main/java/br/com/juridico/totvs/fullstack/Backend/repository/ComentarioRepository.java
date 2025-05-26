package br.com.juridico.totvs.fullstack.Backend.repository;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByPontoTuristicoIdOrderByDataDesc(Long pontoTuristicoId);

}
