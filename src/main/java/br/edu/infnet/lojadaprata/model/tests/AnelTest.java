package br.edu.infnet.lojadaprata.model.tests;

import br.edu.infnet.lojadaprata.model.domain.Anel;
import excecoes.DiametroInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;


public class AnelTest {
    public static void main(String[] args) {
        
        try{
            Anel anel1 = new Anel("Anel","355","59.90","1");
            anel1.setModelo("AnelCoracao");
            anel1.setSobEncomenda(true);
            anel1.setCravejado(true);
            anel1.setDiametro(30); 
            System.out.println(anel1);
            System.out.println("preço dos objetos:"+ anel1.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | DiametroInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        try{    
            Anel anel2 = new Anel("Anel","356","49.90","2");
            anel2.setModelo("AnelCruz");
            anel2.setSobEncomenda(false);
            anel2.setCravejado(true);
            anel2.setDiametro(30); 
            System.out.println(anel2);
            System.out.println("preço dos objetos:"+ anel2.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | DiametroInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        try{
            Anel anel3 = new Anel("Anel","357","59.90","-2");
            anel3.setModelo("AnelAlmaGemea");
            anel3.setSobEncomenda(false);
            anel3.setCravejado(true);
            anel3.setDiametro(30); 
            System.out.println(anel3);
            System.out.println("preço dos objetos:"+ anel3.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | DiametroInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        
        try{
            Anel anel4 = new Anel("Anel","358","139.90","3");
            anel4.setModelo("AnelBolinha");
            anel4.setSobEncomenda(true);
            anel4.setCravejado(true);
            anel4.setDiametro(0); 
            System.out.println(anel4);
            System.out.println("preço dos objetos:"+ anel4.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | DiametroInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }            

        try{
            Anel anel5 = new Anel("Anel","359","79.90","1");
            anel5.setModelo("AnelBasico");
            anel5.setSobEncomenda(true);
            anel5.setCravejado(false);
            anel5.setDiametro(36); 
            System.out.println(anel5);
            System.out.println("preço dos objetos:"+ anel5.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | DiametroInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }            
    }
}
