package br.com.ada.gerenciadorEolico.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @ManyToMany(mappedBy = "usuarios")
    private Set<ParqueEolico> parqueEolicos;
}
