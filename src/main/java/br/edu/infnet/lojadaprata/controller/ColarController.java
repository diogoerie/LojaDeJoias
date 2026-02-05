package br.edu.infnet.lojadaprata.controller;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Colar;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.AnelService;
import br.edu.infnet.lojadaprata.model.service.ColarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ColarController {
	@Autowired
	private ColarService colarService;
	@GetMapping("/cadastroColar")
	public String telaCadastroColar() {
		return "colar/cadastroColar";
	}
	@PostMapping("/colar/novo")
	public String novoColar(Colar colar, @SessionAttribute("cadastro") Usuario cadastro, RedirectAttributes redirectAttributes) {
		colar.setCadastro(cadastro);
		colarService.novo(colar);
		redirectAttributes.addFlashAttribute("mensagem", "Colar cadastrado com sucesso!");
		return "redirect:/listaColar";
	}
	@GetMapping(value = "/colar/{id}/apagar")
	public String apagarColar(@PathVariable Integer id, Model model) {
		try {
			Colar colar = colarService.buscarPorId(id);
			colarService.apagar(id);
			return "redirect:/listaColar";
		} catch (Exception e) {
			model.addAttribute("mensagemErro", "Não foi possível excluir o colar devido a um erro: " + e.getMessage());
			return "colar/listaColar";
		}
	}
	@GetMapping("/listaColar")
	public String telaListaDeAneis(Model model) {
		model.addAttribute("colars", colarService.listagem());
		return "colar/listaColar";
	}
}


