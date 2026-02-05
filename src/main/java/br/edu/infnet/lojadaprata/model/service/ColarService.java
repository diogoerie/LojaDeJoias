package br.edu.infnet.lojadaprata.model.service;


import br.edu.infnet.lojadaprata.model.domain.Colar;
import br.edu.infnet.lojadaprata.model.domain.Pulseira;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.repository.ColarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ColarService {

	@Autowired
	private ColarRepository colarRepository;

	public Colar novo(Colar colar) {
		return colarRepository.save(colar);
	}

	public void apagar(Integer id) {
		if(colarRepository.existsById(id)) {
			colarRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Registro não encontrado");
		}
	}

	public Collection<Colar> listagem(){
		return (Collection<Colar>) colarRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeProduto"));
	}
	public Collection<Colar> listagem(Usuario cadastro){
		return (Collection<Colar>) colarRepository.listagem(cadastro.getId());
	}
	public Colar buscarPorId(Integer id) {
		return colarRepository.findById(id).orElse(null);
	}
	public void atualizar(Colar colar) {
		colarRepository.save(colar);
	}
	public Collection<Colar> listagem2(){
		return colarRepository.findAll(Sort.by(Sort.Direction.ASC, "modelo"));
	}
}
