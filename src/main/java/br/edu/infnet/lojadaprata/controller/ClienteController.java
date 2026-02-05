package br.edu.infnet.lojadaprata.controller;

import br.edu.infnet.lojadaprata.model.domain.Cliente;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/cadastroCliente")
	public String telaCadastro() {
		return "cliente/cadastroCliente";
	}

	@GetMapping(value = "/listaCliente")
	public String telaLista(Model model, @SessionAttribute("cadastro") Usuario cadastro) {
		model.addAttribute("clientes", clienteService.listagem(cadastro));
		return "cliente/listaCliente";
	}

	@PostMapping(value = "/cliente/novo")
	public String novo(Cliente cliente, @SessionAttribute("cadastro") Usuario cadastro) {
		cliente.setCadastro(cadastro);
		clienteService.novo(cliente);
		return "redirect:/listaCliente";
	}

	@GetMapping(value = "/cliente/{id}/apagarCliente")
	public String apagar(@PathVariable Integer id) {
		clienteService.apagar(id);
		return "redirect:/listaCliente";
	}
}