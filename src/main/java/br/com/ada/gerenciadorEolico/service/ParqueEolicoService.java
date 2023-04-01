package br.com.ada.gerenciadorEolico.service;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import br.com.ada.gerenciadorEolico.domain.ParqueEolico;

import java.util.List;

public interface ParqueEolicoService {

    ParqueEolico findById(Long id);
    List<ParqueEolico> list();

    ParqueEolico save(ParqueEolico parqueEolico);

    void delete(Long id);
}
