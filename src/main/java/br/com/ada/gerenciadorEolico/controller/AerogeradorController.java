package br.com.ada.gerenciadorEolico.controller;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import br.com.ada.gerenciadorEolico.service.AerogeradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("aerogeradores")
@RestController
public class AerogeradorController {


    private final AerogeradorService aerogeradorService;

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
    public Aerogerador save(@RequestBody Aerogerador aerogerador) {
        return aerogeradorService.save(aerogerador);
    }

    @PutMapping("{id}")
    public Aerogerador update(@PathVariable Long id, @RequestBody Aerogerador aerogerador){
        return aerogeradorService.update(id, aerogerador);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        aerogeradorService.delete(id);
    }


}
