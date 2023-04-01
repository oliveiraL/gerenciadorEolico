package br.com.ada.gerenciadorEolico.service;

import br.com.ada.gerenciadorEolico.domain.Endereco;
import br.com.ada.gerenciadorEolico.domain.ParqueEolico;
import br.com.ada.gerenciadorEolico.dto.EnderecoDTO;
import br.com.ada.gerenciadorEolico.exceptions.ParqueEolicoNotFoundException;
import br.com.ada.gerenciadorEolico.repository.ParqueEolicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParqueEolicoServiceImpl implements ParqueEolicoService {

    private final ParqueEolicoRepository repository;

    private final RestTemplate restTemplate;

    @Override
    public ParqueEolico findById(Long id) {
        return repository.findById(id).orElseThrow(ParqueEolicoNotFoundException::new);
    }

    @Override
    public List<ParqueEolico> list() {
        return (List<ParqueEolico>) repository.findAll();
    }

    @Override
    public ParqueEolico save(ParqueEolico parqueEolico) {
        String url = "https://cdn.apicep.com/file/apicep/" + parqueEolico.getEndereco().getCep() + ".json";
        EnderecoDTO response = restTemplate.getForObject(url, EnderecoDTO.class);
        Endereco endereco = new Endereco();
        endereco.setCep(response.getCep());
        endereco.setLogradouro(response.getAddress() + " " + response.getDistrict() + " " + response.getCity());
        parqueEolico.setEndereco(endereco);
        return repository.save(parqueEolico);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
