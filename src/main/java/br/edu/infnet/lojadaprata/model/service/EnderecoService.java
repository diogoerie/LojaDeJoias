package br.edu.infnet.lojadaprata.model.service;

import br.edu.infnet.lojadaprata.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private br.edu.infnet.lojadaprata.model.repository.EnderecoService enderecoUsuario;
    public Endereco cepOnline(String cep) {
        return enderecoUsuario.buscarCep(cep);
    }
}