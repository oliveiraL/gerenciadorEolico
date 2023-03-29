package br.com.ada.gerenciadorEolico.service;

import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.repository.ParqueEolicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParqueEolicoServiceImpl implements ParqueEolicoService {

    private final ParqueEolicoRepository repository;

    @Override
    public List<ParqueEolico> list() {
        return (List<ParqueEolico>) repository.findAll();
    }

    @Override
    public ParqueEolico save(ParqueEolico parqueEolico) {
        return repository.save(parqueEolico);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
