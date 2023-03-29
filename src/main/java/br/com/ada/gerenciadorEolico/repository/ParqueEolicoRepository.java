package br.com.ada.gerenciadorEolico.repository;

import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueEolicoRepository extends CrudRepository<ParqueEolico, Long> {
}
