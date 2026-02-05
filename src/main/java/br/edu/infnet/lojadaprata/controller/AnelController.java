package br.edu.infnet.lojadaprata.controller;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.AnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AnelController {

	@Autowired
	private AnelService anelService;

	@GetMapping("/cadastroAnel")
	public String telaCadastroAnel() {
		return "anel/cadastroAnel";
	}
	@PostMapping("/anel/novo")
	public String novoAnel(Anel anel, @SessionAttribute("cadastro") Usuario cadastro, RedirectAttributes redirectAttributes) {
		anel.setCadastro(cadastro);
		anelService.novo(anel);
		redirectAttributes.addFlashAttribute("mensagem", "Anel cadastrado com sucesso!");
		return "redirect:/listaAnel";
	}

	@GetMapping(value = "/anel/{id}/apagar")
	public String apagarAnel(@PathVariable Integer id, Model model) {
		try {
			Anel anel = anelService.buscarPorId(id);
			anelService.apagar(id);
			return "redirect:/listaAnel";
		} catch (Exception e) {
			model.addAttribute("mensagemErro", "Não foi possível excluir o anel devido a um erro: " + e.getMessage());
			return "anel/listaAnel";
		}
	}
	@GetMapping("/listaAnel")
	public String telaListaDeAneis(Model model) {
		model.addAttribute("aneis", anelService.listagem());
		return "anel/listaAnel";
	}
}
