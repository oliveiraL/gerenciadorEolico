package br.com.ada.gerenciadorEolico.config;


import br.com.ada.gerenciadorEolico.domain.Cargo;
import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.domain.Usuario;
import br.com.ada.gerenciadorEolico.repository.ParqueEolicoRepository;
import br.com.ada.gerenciadorEolico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Transactional
public class InitProject implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ParqueEolicoRepository parqueEolicoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario usuario = usuarioRepository.findById(1L).get();
        ParqueEolico parqueEolico = parqueEolicoRepository.findById(52L).get();
        parqueEolico.getUsuarios().add(usuario);
        parqueEolicoRepository.save(parqueEolico);
    }
}
