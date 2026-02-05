package br.edu.infnet.lojadaprata.controller;

import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String telaIndex() {
		return "index";
	}
	@GetMapping("/logado")
	public String telaLogado(Usuario cadastro) {
		return "index";
	}


}