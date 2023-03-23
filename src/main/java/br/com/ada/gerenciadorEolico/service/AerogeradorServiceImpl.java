package br.com.ada.gerenciadorEolico.service;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AerogeradorServiceImpl implements AerogeradorService {

    private List<Aerogerador> aerogeradores = new ArrayList<>();

    public List<Aerogerador> list() {
        return aerogeradores;
    }

    @Override
    public Aerogerador save(Aerogerador aerogerador) {
        aerogerador.setId(aerogeradores.size() + 1L);
        aerogeradores.add(aerogerador);
        return aerogerador;
    }

    @Override
    public Aerogerador findById(Long id) {
        return aerogeradores.stream().filter(aerogerador -> aerogerador.getId() == id).findFirst().get();
    }

    @Override
    public Aerogerador update(Long id, Aerogerador aerogerador) {
        aerogerador.setId(id);
        int index = aerogeradores.indexOf(aerogerador);
        aerogeradores.set(index, aerogerador);
        return aerogerador;
    }

    @Override
    public void delete(Long id) {
        Aerogerador aerogerador = Aerogerador.builder().id(id).build();
        aerogeradores.remove(aerogerador);
    }
}