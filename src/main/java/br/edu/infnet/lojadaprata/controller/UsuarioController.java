package br.edu.infnet.lojadaprata.controller;

import br.edu.infnet.lojadaprata.model.domain.Produto;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/cadastro")
	public String telaCadastro() {
		return "cadastro/cadastro";
	}

	@PostMapping(value = "/cadastro/novo")
	public String novoCadastro(Usuario cadastro) {
		usuarioService.novo(cadastro);
		return "redirect:/login";
	}
	@GetMapping("/cadastrologado")
	public String telaCadastroLogado() {
		return "cadastro/cadastrologado";
	}

	@GetMapping(value = "/cadastro/{id}/apagar")
	public String apagarCadastro(@PathVariable Integer id) {
		Usuario cadastro = usuarioService.buscarPorId(id);
		usuarioService.apagar(id);
		return "redirect:/listadecadastros";
	}
	@PostMapping("/cadastro/novologado")
	public String novologado(Usuario cadastro) {
		usuarioService.novo(cadastro);
		return "redirect:/listadecadastros";
	}
	@GetMapping(value = "/listadecadastros")
	public String telaLista(Model model) {
		model.addAttribute("cadastros", usuarioService.listagem());
		return "cadastro/listadecadastros";
	}
}
