package br.com.ada.gerenciadorEolico.service;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;

import java.util.List;

public interface AerogeradorService {
    List<Aerogerador> list();

    Aerogerador save(Aerogerador aerogerador);

    Aerogerador findById(Long id);

    Aerogerador update(Long id, Aerogerador aerogerador);

    void delete(Long id);
}
