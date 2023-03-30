package br.com.ada.gerenciadorEolico.mapper;

import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.dto.ParqueEolicoListDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParqueEolicoMapper {

    ParqueEolicoListDTO parqueEolicoToParqueEolicoListDTO(ParqueEolico parqueEolico);
}
