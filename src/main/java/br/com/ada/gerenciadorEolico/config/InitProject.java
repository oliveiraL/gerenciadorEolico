package br.com.ada.gerenciadorEolico.config;


import br.com.ada.gerenciadorEolico.domain.Cargo;
import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.domain.Usuario;
import br.com.ada.gerenciadorEolico.repository.ParqueEolicoRepository;
import br.com.ada.gerenciadorEolico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Transactional
public class InitProject implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setUsername("ada");
        usuario.setPassword(passwordEncoder.encode("1234"));
        usuario.setName("Lucio");
        usuario.setEmail("lucio@email.com");
        usuario.setCargo(Cargo.DEV);

        usuarioRepository.save(usuario);
    }
}
