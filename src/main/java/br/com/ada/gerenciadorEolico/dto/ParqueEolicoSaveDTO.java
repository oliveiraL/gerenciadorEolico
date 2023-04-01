package br.com.ada.gerenciadorEolico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class ParqueEolicoSaveDTO {
    @NotBlank
    private String nome;
    @CNPJ
    private String cnpj;
    @NotNull
    private Double potencia;
    @NotBlank
    @Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "CEP invalido")
    private String cep;
}
