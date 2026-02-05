package br.edu.infnet.lojadaprata.dataLoader;

import br.edu.infnet.lojadaprata.model.domain.Cliente;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Order(2)
@Component
public class ClienteLoader implements ApplicationRunner {

    @Autowired
    private ClienteService clienteService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String arq = "clientes.txt";
            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    Usuario cadastro = new Usuario();
                    cadastro.setId(1);
                    Cliente cliente = new Cliente(
                            campos[0],
                            campos[1],
                            campos[2]
                    );
                    cliente.setCadastro(cadastro);
                    clienteService.novo(cliente);
                    System.out.println("Usuário "+cliente.getNome()+" incluido na lista.");
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
