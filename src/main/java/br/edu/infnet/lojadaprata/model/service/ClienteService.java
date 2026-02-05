package br.edu.infnet.lojadaprata.model.service;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Cliente;
import br.edu.infnet.lojadaprata.model.domain.Pedido;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente novo(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void apagar(Integer key) {
		clienteRepository.deleteById(key);
	}

	public Collection<Cliente> listagem(){
		return (Collection<Cliente>) clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Collection<Cliente> listagem(Usuario cadastro){
		return clienteRepository.listagem(cadastro.getId());
	}
	public Collection<Cliente> listarTodos(){
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	public Cliente getById(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

}
