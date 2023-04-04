package br.com.ada.gerenciadorEolico.controller;

import br.com.ada.gerenciadorEolico.dto.UsuarioLogin;
import br.com.ada.gerenciadorEolico.service.JwtUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    @PostMapping
    public String login(@Valid @RequestBody UsuarioLogin login) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.login(), login.senha()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtUtils.generateJwtToken(authentication);
    }
}
