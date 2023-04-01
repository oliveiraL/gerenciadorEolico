package br.com.ada.gerenciadorEolico.repository;

import br.com.ada.gerenciadorEolico.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
