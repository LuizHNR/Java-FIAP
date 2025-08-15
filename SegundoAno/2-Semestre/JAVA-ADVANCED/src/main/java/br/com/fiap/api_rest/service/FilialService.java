package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.FilialRequest;
import br.com.fiap.api_rest.dto.FilialResponse;
import br.com.fiap.api_rest.model.Endereco;
import br.com.fiap.api_rest.model.Filial;
import br.com.fiap.api_rest.repository.EnderecoRepository;
import br.com.fiap.api_rest.repository.FilialRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilialService {
    @Autowired
    FilialRepository filialRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    private FilialResponse filialToResponse(Filial filial) {
        return new FilialResponse(
                filial.getId(),
                filial.getNome(),
                filial.getEndereco().getLocalizacao());
    }

    public FilialResponse create(FilialRequest filialRequest) {
        // Testa o endereço recebido e salva no banco
        Endereco endereco = new Endereco();
        if (filialRequest.endereco() != null) {
            endereco = enderecoRepository.save(filialRequest.endereco());
        }
        // Mapeia o filialRequest com o endereço gravado anteriormente
        Filial filial = new Filial(filialRequest.nome(), endereco);
        filial = filialRepository.save(filial);
        return filialToResponse(filial);
    }

    public FilialResponse findById(Long id) {
        Optional<Filial> filial = filialRepository.findById(id);
        if (filial.isPresent()) {
            return filialToResponse(filial.get());
        }
        return null;
    }

    public List<FilialResponse> findAll() {
        List<Filial> filiais = filialRepository.findAll();
        List<FilialResponse> filialResponses = new ArrayList<>();
        for (Filial filial : filiais) {
            filialResponses.add(filialToResponse(filial));
        }
        return filialResponses;
    }

    public FilialResponse update(Long id, FilialRequest filialRequest) {
        // Busca a filial no banco
        Optional<Filial> filial = filialRepository.findById(id);
        if (filial.isEmpty()) {
            return null;
        }
        // Atribui o id existente ao endereço recebido e atualiza no banco
        Endereco endereco = filialRequest.endereco();
        endereco.setId(filial.get().getEndereco().getId());
        endereco = enderecoRepository.save(endereco);
        // Mapeia filial com o endereço atualizado
        filial.get().setEndereco(endereco);
        // Mapeia os demais campos
        filial.get().setNome(filialRequest.nome());
        // Atualiza filial no banco e retorna como FilialResponse
        return filialToResponse(filialRepository.save(filial.get()));
    }

    public boolean delete(Long id) {
        Optional<Filial> filial = filialRepository.findById(id);
        if (filial.isEmpty()) {
            return false;
        }
        filialRepository.delete(filial.get());
        return true;
    }
}
