package br.edu.infnet.lojadaprata.dataLoader;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.AnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Order(5)
@Component
public class AnelLoader implements ApplicationRunner {

    @Autowired
    private AnelService anelService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "aneis.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    Usuario cadastro = new Usuario();
                    cadastro.setId(1);

                    Anel anel = new Anel(campos[0], campos[1], campos[2],campos[3]);
                    anel.setModelo(campos[7]);
                    anel.setSobEncomenda(Boolean.valueOf(campos[4]));
                    anel.setCravejado(Boolean.valueOf(campos[5]));
                    anel.setDiametro(Integer.valueOf(campos[6]));
                    anel.setCadastro(cadastro);
                    anelService.novo(anel);
                    System.out.println("A inclusão do anel "+anel.getNomeProduto()+" foi realizada com sucesso.");

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
