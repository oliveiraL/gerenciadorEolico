package br.com.ada.gerenciadorEolico.service;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import br.com.ada.gerenciadorEolico.domain.ParqueEolico;

import java.util.List;

public interface ParqueEolicoService {
    List<ParqueEolico> list();

    ParqueEolico save(ParqueEolico parqueEolico);

    void delete(Long id);
}
