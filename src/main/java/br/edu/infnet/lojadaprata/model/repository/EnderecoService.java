package br.edu.infnet.lojadaprata.model.repository;

import br.edu.infnet.lojadaprata.model.domain.Endereco;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface EnderecoService {

    @GetMapping(value = "/{cep}/json")
    public Endereco buscarCep(@PathVariable String cep);
}