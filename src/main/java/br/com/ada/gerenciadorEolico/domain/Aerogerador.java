package br.com.ada.gerenciadorEolico.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Aerogerador {
    private Long id;
    private String modelo;
    private String numeroSerie;
    private AerogeradorStatus status;
}
