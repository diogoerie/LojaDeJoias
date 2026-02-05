package br.edu.infnet.lojadaprata.dataLoader;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Cliente;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.ClienteService;
import br.edu.infnet.lojadaprata.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario vendedor = new Usuario("Diogo1 ", "diogo1@gmail.com", "diogo1@gmail.com");
        vendedor.setIdade(18);
        usuarioService.novo(vendedor);
        System.out.println("Usuário " + vendedor.getNome() + " incluido na lista.");

        Usuario adm = new Usuario("Diogo ", "diogo@gmail.com", "diogo@gmail.com");
        adm.setId(1);
        adm.setIdade(18);
        adm.setAdministrador(true);
        usuarioService.novo(adm);
        System.out.println("Usuário " + adm.getNome() + " incluido na lista.");


        try {
            String arq = "usuarios.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    Usuario cadastro = new Usuario(campos[0], campos[1],(campos[2]));
                    cadastro.setIdade(Integer.valueOf(campos[4]));
                    usuarioService.novo(cadastro);
                    System.out.println("A inclusão do usuario "+cadastro.getNome()+" foi realizada com sucesso.");
                    linha = leitura.readLine();
                }
                leitura.close();
                fileR.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("A inclusão foi um sucesso.");
        }
    }
}
