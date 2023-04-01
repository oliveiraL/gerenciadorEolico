package br.com.ada.gerenciadorEolico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    @JsonProperty("code")
    private String cep;
    private String address;
    private String city;
    private String district;
}