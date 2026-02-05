package br.edu.infnet.lojadaprata.controller;

import br.edu.infnet.lojadaprata.model.domain.Pulseira;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.PulseiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PulseiraController {

	@Autowired
	private PulseiraService pulseiraService;

	@GetMapping("/cadastroPulseira")
	public String telaCadastroPulseira() {
		return "pulseira/cadastroPulseira";
	}

	@PostMapping("/pulseira/novo")
	public String novoPulseira(Pulseira pulseira, @SessionAttribute("cadastro") Usuario cadastro, RedirectAttributes redirectAttributes) {
		try {
			pulseira.setCadastro(cadastro);
			pulseiraService.novo(pulseira);
			redirectAttributes.addFlashAttribute("mensagem", "Pulseira cadastrada com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagemErro", "Não foi possível cadastrar a pulseira devido a um erro: " + e.getMessage());
		}
		return "redirect:/listaPulseira";
	}

	@GetMapping(value = "/pulseira/{id}/apagar")
	public String apagarPulseira(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
		try {
			Pulseira pulseira = pulseiraService.buscarPorId(id);
			pulseiraService.apagar(id);
			redirectAttributes.addFlashAttribute("mensagem", "Pulseira excluída com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagemErro", "Não foi possível excluir a pulseira devido a um erro: " + e.getMessage());
		}
		return "redirect:/listaPulseira";
	}

	@GetMapping("/listaPulseira")
	public String telaListaDePulseiras(Model model) {
		model.addAttribute("pulseiras", pulseiraService.listagem());
		return "pulseira/listaPulseira";
	}

}
