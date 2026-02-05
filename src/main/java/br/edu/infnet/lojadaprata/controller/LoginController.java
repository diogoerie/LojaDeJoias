package br.edu.infnet.lojadaprata.controller;

import javax.servlet.http.HttpSession;

import br.edu.infnet.lojadaprata.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import br.edu.infnet.lojadaprata.model.domain.Usuario;


@Controller
@SessionAttributes("cadastro")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/login")
	public String telaLogin(Model model) {
		model.addAttribute("erro", null);
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		Usuario user = new Usuario(email, senha);
		user = usuarioService.autenticar(user);
		if (user != null) {
			model.addAttribute("cadastro", user);
			return "redirect:/";
		} else {
			model.addAttribute("erro", "E-mail e/ou senha incorretos");
			return telaLogin(model);
		}
	}


	@GetMapping("/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("cadastro");
		return "redirect:/";
	}
}
