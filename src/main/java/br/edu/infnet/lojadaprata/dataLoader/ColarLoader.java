package br.edu.infnet.lojadaprata.dataLoader;

import br.edu.infnet.lojadaprata.model.domain.Colar;
import br.edu.infnet.lojadaprata.model.domain.Pulseira;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.ColarService;
import excecoes.DiametroInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Order(4)
@Component
public class ColarLoader implements ApplicationRunner {

    @Autowired
    private ColarService colarService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "colares.txt";
            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    Usuario cadastro = new Usuario();
                    cadastro.setId(1);
                    Colar colar = new Colar(campos[0], campos[1], campos[2],campos[3]);
                    colar.setModelo(campos[4]);
                    colar.setPingente(Boolean.valueOf(campos[5]));
                    colar.setPeso(Integer.valueOf(campos[6]));
                    colar.setCadastro(cadastro);
                    colarService.novo(colar);
                    System.out.println("A inclusão do colar "+colar.getNomeProduto()+" foi realizada com sucesso.");
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