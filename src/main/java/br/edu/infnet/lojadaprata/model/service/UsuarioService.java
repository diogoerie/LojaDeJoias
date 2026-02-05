package br.edu.infnet.lojadaprata.model.service;


import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario autenticar(Usuario cadastro) {
		return usuarioRepository.autenticacao(cadastro.getEmail(), cadastro.getSenha());
	}
	public void novo(Usuario cadastro) {
		usuarioRepository.save(cadastro);
	}
	public void apagar(Integer key) {
		usuarioRepository.deleteById(key);
	}
	public Collection<Usuario> listagem(){
		return (Collection<Usuario>) usuarioRepository.findAll();
	}
	public Usuario buscarPorId(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}


}
