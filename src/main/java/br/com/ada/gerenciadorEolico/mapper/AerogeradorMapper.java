package br.com.ada.gerenciadorEolico.mapper;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import br.com.ada.gerenciadorEolico.dto.AerogeradorSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AerogeradorMapper {

    @Mapping(target = "parqueEolico", ignore = true)
    Aerogerador aerogeradorSaveDTOToAerogerador(AerogeradorSaveDTO dto);
}
