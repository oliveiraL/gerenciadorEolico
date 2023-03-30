package br.com.ada.gerenciadorEolico.repository;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerogeradorRepository extends CrudRepository<Aerogerador, Long> {

    boolean existsByNumeroSerie(String numeroSerie);
}
