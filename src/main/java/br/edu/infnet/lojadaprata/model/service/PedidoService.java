package br.edu.infnet.lojadaprata.model.service;

import br.edu.infnet.lojadaprata.model.domain.Pedido;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	public Pedido novo(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	public void apagar(Integer id) {
		pedidoRepository.deleteById(id);
	}
	public Collection<Pedido> listagem(){
		return (Collection<Pedido>) pedidoRepository.findAll();
	}
	public Collection<Pedido> listagem(Usuario cadastro){
		return (Collection<Pedido>) pedidoRepository.obterLista(cadastro.getId());
	}
	public Pedido obterPorId(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}

}
