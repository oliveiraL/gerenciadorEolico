package br.com.ada.gerenciadorEolico.controller;


import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.dto.AerogeradorSaveDTO;
import br.com.ada.gerenciadorEolico.dto.ParqueEolicoListDTO;
import br.com.ada.gerenciadorEolico.mapper.ParqueEolicoMapper;
import br.com.ada.gerenciadorEolico.service.ParqueEolicoService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parque-eolico")
@RequiredArgsConstructor
public class ParqueEolicoController {

    private final ParqueEolicoService service;

    private final ParqueEolicoMapper mapper;

    @GetMapping
    public List<ParqueEolicoListDTO> list() {
        return service.list().stream().map(mapper::parqueEolicoToParqueEolicoListDTO).toList();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParqueEolico save(@RequestBody ParqueEolico dto) {
        return service.save(dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
