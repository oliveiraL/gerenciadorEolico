package br.com.ada.gerenciadorEolico.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Aerogerador {
    private Long id;
    private String modelo;
    private String numeroSerie;
    private AerogeradorStatus status;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aerogerador that = (Aerogerador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, numeroSerie, status);
    }
}
