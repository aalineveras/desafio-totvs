package br.com.juridico.totvs.fullstack.Backend.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.repository.PontoTuristicoRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.List;

@Component

public class PontoTuristicoDataLoader implements CommandLineRunner {

    @Autowired
    private PontoTuristicoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("pontos.json").getInputStream();

            List<PontoTuristico> pontos = mapper.readValue(inputStream, new TypeReference<List<PontoTuristico>>() {});
            repository.saveAll(pontos);

            System.out.println("Pontos turísticos carregados com sucesso!");
        }
    }
}