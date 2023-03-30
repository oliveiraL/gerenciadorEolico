package br.com.ada.gerenciadorEolico.service;

import br.com.ada.gerenciadorEolico.domain.Aerogerador;
import br.com.ada.gerenciadorEolico.exceptions.AerogeradorNotFoundException;
import br.com.ada.gerenciadorEolico.exceptions.AerogeradorNumeroSerieException;
import br.com.ada.gerenciadorEolico.repository.AerogeradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AerogeradorServiceImpl implements AerogeradorService {

    private final AerogeradorRepository repository;

    public List<Aerogerador> list() {
        return (List<Aerogerador>) repository.findAll();
    }

    @Override
    public Aerogerador save(Aerogerador aerogerador) {
        if (repository.existsByNumeroSerie(aerogerador.getNumeroSerie())){
            throw new AerogeradorNumeroSerieException();
        }
        return repository.save(aerogerador);
    }

    @Override
    public Aerogerador findById(Long id) {
        return repository.findById(id).orElseThrow(AerogeradorNotFoundException::new);
    }

    @Override
    public Aerogerador update(Long id, Aerogerador aerogerador) {
        if (repository.existsById(id)) {
            aerogerador.setId(id);
            return repository.save(aerogerador);
        }
        throw new AerogeradorNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new AerogeradorNotFoundException();
        }
        repository.deleteById(id);
    }

}
