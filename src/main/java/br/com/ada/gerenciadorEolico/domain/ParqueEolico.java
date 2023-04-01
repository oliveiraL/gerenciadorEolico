package br.com.ada.gerenciadorEolico.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParqueEolico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cnpj;
    private Double potencia;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private Endereco endereco;

    @OneToMany(mappedBy = "parqueEolico")
    @JsonIgnoreProperties("parqueEolico")
    private List<Aerogerador> aerogeradores;

    @ManyToMany
    @JoinTable(
            name = "parque_eolico_usuarios",
            joinColumns = @JoinColumn(name = "parque_eolico_id"),
            inverseJoinColumns = @JoinColumn(name = "usuarios_id")
    )
    @JsonIgnoreProperties("parqueEolicos")
    private Set<Usuario> usuarios;
}
