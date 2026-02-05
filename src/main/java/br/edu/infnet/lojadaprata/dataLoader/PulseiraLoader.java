package br.edu.infnet.lojadaprata.dataLoader;

import br.edu.infnet.lojadaprata.model.domain.Pulseira;
import br.edu.infnet.lojadaprata.model.domain.Usuario;
import br.edu.infnet.lojadaprata.model.service.PulseiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Order(3)
@Component
public class PulseiraLoader implements ApplicationRunner {
    @Autowired
    private PulseiraService pulseiraService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "pulseiras.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                String linha = leitura.readLine();
                String[] campos = null;
                while(linha != null) {
                    campos = linha.split(";");
                    Usuario cadastro = new Usuario();
                    cadastro.setId(1);

                    Pulseira pulseira = new Pulseira(campos[0], campos[1], campos[2],campos[3]);
                    pulseira.setModelo(campos[4]);
                    pulseira.setMaleavel(Boolean.valueOf(campos[5]));
                    pulseira.setPrendedor(Boolean.valueOf(campos[6]));
                    pulseira.setTamanho(Integer.valueOf(campos[7]));
                    pulseira.setCadastro(cadastro);
                    pulseiraService.novo(pulseira);
                    System.out.println("A inclusão da pulseira "+pulseira.getNomeProduto()+" foi realizada com sucesso.");

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