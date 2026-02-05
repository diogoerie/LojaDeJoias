package br.edu.infnet.lojadaprata.model.service;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Colar;
import br.edu.infnet.lojadaprata.model.domain.Pulseira;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.repository.ColarRepository;
import br.edu.infnet.lojadaprata.model.repository.PulseiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PulseiraService {

	@Autowired
	private PulseiraRepository pulseiraRepository;

	public Pulseira novo(Pulseira pulseira) {
		return pulseiraRepository.save(pulseira);
	}

	public void apagar(Integer id) {
		if(pulseiraRepository.existsById(id)) {
			pulseiraRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Registro não encontrado");
		}
	}

	public Collection<Pulseira> listagem(){
		return (Collection<Pulseira>) pulseiraRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeProduto"));
	}
	public Collection<Pulseira> listagem(Usuario cadastro){
		return (Collection<Pulseira>) pulseiraRepository.listagem(cadastro.getId());
	}
	public Pulseira buscarPorId(Integer id) {
		return pulseiraRepository.findById(id).orElse(null);
	}
	public void atualizar(Pulseira pulseira) {
		pulseiraRepository.save(pulseira);
	}
	public Collection<Pulseira> listagem2(){
		return pulseiraRepository.findAll(Sort.by(Sort.Direction.ASC, "modelo"));
	}
}
