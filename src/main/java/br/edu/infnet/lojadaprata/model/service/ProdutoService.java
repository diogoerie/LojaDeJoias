package br.edu.infnet.lojadaprata.model.service;

import br.edu.infnet.lojadaprata.model.domain.Produto;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public void apagar(Integer id) {
		produtoRepository.deleteById(id);
	}
	public Collection<Produto> listagem() {
		return (Collection<Produto>) produtoRepository.findAll();
	}
	public Collection<Produto> listagem(Usuario cadastro){
		return (Collection<Produto>) produtoRepository.listagem(cadastro.getId());}
	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}
}
