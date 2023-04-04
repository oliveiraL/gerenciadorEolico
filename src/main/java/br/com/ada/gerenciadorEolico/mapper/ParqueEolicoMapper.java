package br.com.ada.gerenciadorEolico.mapper;

import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.dto.ParqueEolicoListDTO;
import br.com.ada.gerenciadorEolico.dto.ParqueEolicoSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParqueEolicoMapper {


    ParqueEolico parqueEolicoSaveDTOToParqueEolico(ParqueEolicoSaveDTO dto);

    ParqueEolicoListDTO parqueEolicoToParqueEolicoListDTO(ParqueEolico parqueEolico);
}
