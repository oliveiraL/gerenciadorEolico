package br.com.ada.gerenciadorEolico.mapper;

import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.dto.ParqueEolicoListDTO;
import br.com.ada.gerenciadorEolico.dto.ParqueEolicoSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParqueEolicoMapper {

    @Mapping(source = "cep", target = "endereco", ignore = true)
    ParqueEolico parqueEolicoSaveDTOToParqueEolico(ParqueEolicoSaveDTO dto);

    ParqueEolicoListDTO parqueEolicoToParqueEolicoListDTO(ParqueEolico parqueEolico);
}
