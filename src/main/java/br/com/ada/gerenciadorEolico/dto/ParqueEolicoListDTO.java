package br.com.ada.gerenciadorEolico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParqueEolicoListDTO {
    private Long id;
    private String nome;
    private String cnpj;
    private Double potencia;
}
