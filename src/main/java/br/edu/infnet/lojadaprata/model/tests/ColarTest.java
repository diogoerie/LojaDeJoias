package br.edu.infnet.lojadaprata.model.tests;

import br.edu.infnet.lojadaprata.model.domain.Colar;
import excecoes.PesoInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;


public class ColarTest {
    public static void main(String[] args) {
        
        try{
            Colar a1 = new Colar("Colar","355","189.90","2");
            a1.setModelo("ColarCravejadoZirconeo");
            a1.setPingente(false);
            a1.setPeso(125);
            System.out.println(a1);
            System.out.println("preço dos objetos:"+ a1.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | PesoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        
        try{
            Colar a2 = new Colar("Colar","356","149.90","1");
            a2.setModelo("ColarAncora");
            a2.setPingente(true);
            a2.setPeso(75);
            System.out.println(a2);
            System.out.println("preço dos objetos:"+ a2.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | PesoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        
        try{
            Colar a3 = new Colar("Colar","357","159.90","5");
            a3.setModelo("ColarVeneziana");
            a3.setPingente(true);
            a3.setPeso(0);
            System.out.println(a3);
            System.out.println("preço dos objetos:"+ a3.calcularPreco());

        }catch(QuantidadeInvalidaExcecao | PesoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        
        try{
            Colar a4 = new Colar("Colar","358","239.90","1");
            a4.setModelo("ColarPiramide");
            a4.setPingente(false);
            a4.setPeso(340);
            System.out.println(a4);
            System.out.println("preço dos objetos:"+ a4.calcularPreco());

        }catch(QuantidadeInvalidaExcecao | PesoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        
        try{
            Colar a5 = new Colar("Colar","359","179.90","0");
            a5.setModelo("ColarTorreEiffel");
            a5.setPingente(true);
            a5.setPeso(93);
            System.out.println(a5);
            System.out.println("preço dos objetos:"+ a5.calcularPreco());

        }catch(QuantidadeInvalidaExcecao | PesoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
    }
}