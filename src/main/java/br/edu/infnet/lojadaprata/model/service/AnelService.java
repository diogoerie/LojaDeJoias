package br.edu.infnet.lojadaprata.model.service;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.repository.AnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class AnelService {

	@Autowired
	private AnelRepository anelRepository;

	public Anel novo(Anel anel) {
		return anelRepository.save(anel);
	}

	public void apagar(Integer id) {
		if(anelRepository.existsById(id)) {
			anelRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Registro não encontrado");
		}
	}
	public Collection<Anel> listagem(Usuario cadastro){
		return (Collection<Anel>) anelRepository.listagem(cadastro.getId());
	}
	public Collection<Anel> listagem(){
		return (Collection<Anel>) anelRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeProduto"));
	}

	public Anel buscarPorId(Integer id) {
		return anelRepository.findById(id).orElse(null);
	}
	public void atualizar(Anel anel) {
		anelRepository.save(anel);
	}
	public Collection<Anel> listagem2(){
		return anelRepository.findAll(Sort.by(Sort.Direction.ASC, "modelo"));
	}

}
