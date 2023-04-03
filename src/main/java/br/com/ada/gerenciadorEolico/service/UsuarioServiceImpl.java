package br.com.ada.gerenciadorEolico.service;

import br.com.ada.gerenciadorEolico.domain.Usuario;
import br.com.ada.gerenciadorEolico.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository repository;

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }
}
