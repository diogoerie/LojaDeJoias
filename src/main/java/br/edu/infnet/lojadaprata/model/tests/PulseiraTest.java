package br.edu.infnet.lojadaprata.model.tests;

import br.edu.infnet.lojadaprata.model.domain.Pulseira;
import excecoes.QuantidadeInvalidaExcecao;
import excecoes.TamanhoInvalidoExcecao;

public class PulseiraTest {
    public static void main(String[] args) {

        
        try{
            Pulseira pulseira1 = new Pulseira("Pulseira","455","79.90","10");
            pulseira1.setModelo("PulseiraTrancada");
            pulseira1.setMaleavel(false);
            pulseira1.setPrendedor(false);
            pulseira1.setTamanho(10);
            System.out.println(pulseira1);
            System.out.println("Valor total:"+ pulseira1.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | TamanhoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        //catch(){}
        
        try{
            Pulseira pulseira2 = new Pulseira("Pulseira","456","59.90","3");
            pulseira2.setModelo("PulseiraCravejada");
            pulseira2.setMaleavel(true);
            pulseira2.setPrendedor(false);
            pulseira2.setTamanho(15);
            System.out.println(pulseira2);
            System.out.println("Valor total:"+ pulseira2.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | TamanhoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }

        try{
            Pulseira pulseira3 = new Pulseira("Pulseira","457","109.90","-1");
            pulseira3.setModelo("PulseiraPataCao");
            pulseira3.setMaleavel(false);
            pulseira3.setPrendedor(true);
            pulseira3.setTamanho(25);
            System.out.println(pulseira3);
            System.out.println("Valor total:"+ pulseira3.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | TamanhoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        
        try{
            Pulseira pulseira4 = new Pulseira("Pulseira","458","89.90","1");
            pulseira4.setModelo("PulseiraEstrelaDavi");
            pulseira4.setMaleavel(true);
            pulseira4.setPrendedor(false);
            pulseira4.setTamanho(0);
            System.out.println(pulseira4);
            System.out.println("Valor total:"+ pulseira4.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | TamanhoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        try{
            Pulseira pulseira5 = new Pulseira("Pulseira","459","119.90","0");
            pulseira5.setModelo("PulseiraAncora");
            pulseira5.setMaleavel(false);
            pulseira5.setPrendedor(true);
            pulseira5.setTamanho(30);
            System.out.println(pulseira5);
            System.out.println("Valor total:"+ pulseira5.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | TamanhoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
    }
}
