package br.edu.infnet.lojadaprata.model.repository;

import br.edu.infnet.lojadaprata.model.domain.Usuario;

public class LoginRepository {
	public static Usuario autenticar(Usuario cadastro) {
		if (cadastro.getEmail().equalsIgnoreCase(cadastro.getSenha())) {
			return new Usuario("Cadastro", cadastro.getEmail(), cadastro.getSenha());
		}
		return null;
	}
}
