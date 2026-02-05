package br.edu.infnet.lojadaprata.model.tests;

import br.edu.infnet.lojadaprata.model.domain.*;
import excecoes.ClienteInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

    public static void main(String[] args) {

        try {
            String arq = "produtoslista.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);
                FileWriter fileW = new FileWriter("out_" + arq);
                BufferedWriter escrita = new BufferedWriter(fileW);
                String linha = leitura.readLine();
                String[] campos = null;

                List<Produto> produtos = new ArrayList<Produto>();
                Pedido pedido = null;

                while (linha != null) {

                    campos = linha.split(";");

                    switch (campos[0].toUpperCase()) {
                        case "O":					
                            try {
                            pedido = new  Pedido(new Cliente(campos[1], campos[2], campos[3]), produtos);
                            pedido.setCarrinho(campos[4]);
                            pedido.setCodigoProduto(campos[5]);
                        } catch (QuantidadeInvalidaExcecao | ClienteInvalidoExcecao e) {
                            System.out.println("[ERRO] " + e.getMessage());
                        }

                        break;
                        case "P":					
                            try {
                            Pulseira pulseira = new Pulseira(campos[1], campos[2], campos[3], campos[4]);
                            pulseira.setModelo(campos[5]);
                            pulseira.setMaleavel(Boolean.valueOf(campos[6]));
                            pulseira.setPrendedor(Boolean.valueOf(campos[7]));
                            pulseira.setTamanho(Integer.valueOf(campos[8]));
                            produtos.add(pulseira);
                        } catch (QuantidadeInvalidaExcecao e) {
                            System.out.println("ERRO: " + e.getMessage());
                        }

                        break;
                        case "C":
                            try {
                            Colar colar = new Colar(campos[1], campos[2], campos[3], campos[4]);
                            colar.setModelo(campos[5]);
                            colar.setPingente(Boolean.valueOf(campos[6]));
                            colar.setPeso(Integer.valueOf(campos[7]));
                            produtos.add(colar);
                        } catch (QuantidadeInvalidaExcecao e) {
                            System.out.println("ERRO: " + e.getMessage());
                        }
                        break;
                        case "A":
                            try {
                            Anel anel = new Anel(campos[1], campos[2], campos[3], campos[4]);
                            anel.setModelo(campos[8]);
                            anel.setSobEncomenda(Boolean.valueOf(campos[5]));
                            anel.setCravejado(Boolean.valueOf(campos[6]));
                            anel.setDiametro(Integer.valueOf(campos[7]));
                            produtos.add(anel);
                        } catch (QuantidadeInvalidaExcecao e) {
                            System.out.println("ERRO: " + e.getMessage());
                        }
                        break;

                        default:
                            System.out.println("Não foi possível completar.");
                            break;
                    }

                    linha = leitura.readLine();
                }

                escrita.write(pedido.obterLinha());

                escrita.close();
                leitura.close();
                fileR.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }

        } finally {
            System.out.println("Processamento realizado com sucesso!!!");
        }
    }
}
