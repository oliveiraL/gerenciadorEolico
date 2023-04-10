package br.com.ada.gerenciadorEolico.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Aerogerador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String modelo;

    @Column(unique = true)
    private String numeroSerie;

    @Enumerated(EnumType.STRING)
    private AerogeradorStatus status;
    private LocalDateTime createdAt;


    @ManyToOne(fetch = FetchType.EAGER)
    private ParqueEolico parqueEolico;
}
