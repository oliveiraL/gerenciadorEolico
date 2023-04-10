package br.com.ada.gerenciadorEolico.controller;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.dto.AerogeradorSaveDTO;
import br.com.ada.gerenciadorEolico.mapper.AerogeradorMapper;
import br.com.ada.gerenciadorEolico.service.AerogeradorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("aerogeradores")
@RestController
public class AerogeradorController {


    private final AerogeradorService aerogeradorService;
    private final AerogeradorMapper mapper;

    @GetMapping
    public List<Aerogerador> list() {
        return aerogeradorService.list();
    }

    @GetMapping("{id}")
    public Aerogerador getById(@PathVariable Long id) {
        return aerogeradorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aerogerador save(@Valid @RequestBody AerogeradorSaveDTO dto) {
        Aerogerador aerogerador = mapper.aerogeradorSaveDTOToAerogerador(dto);
        aerogerador.setParqueEolico(ParqueEolico.builder().id(dto.getParqueEolicoId()).build());
        return aerogeradorService.save(aerogerador);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_DEV')")
    @PutMapping("{id}")
    public Aerogerador update(@PathVariable Long id, @RequestBody AerogeradorSaveDTO dto) {
        Aerogerador aerogerador = mapper.aerogeradorSaveDTOToAerogerador(dto);
        aerogerador.setParqueEolico(ParqueEolico.builder().id(dto.getParqueEolicoId()).build());
        return aerogeradorService.update(id, aerogerador);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        aerogeradorService.delete(id);
    }


}
