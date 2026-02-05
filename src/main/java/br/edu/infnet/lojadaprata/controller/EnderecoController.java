package br.edu.infnet.lojadaprata.controller;

import br.edu.infnet.lojadaprata.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/cep")
    public String telaCep(Model model, @RequestParam String cep) {
        model.addAttribute("endereco", enderecoService.cepOnline(cep));
        return "cadastro/cadastro";
    }
    @PostMapping("/cep1")
    public String telaCep1(Model model, @RequestParam String cep) {
        model.addAttribute("endereco", enderecoService.cepOnline(cep));
        return "cliente/cadastroCliente";
    }

}
