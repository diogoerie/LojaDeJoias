package br.edu.infnet.lojadaprata.model.tests;

import br.edu.infnet.lojadaprata.model.domain.*;
import excecoes.ClienteInvalidoExcecao;
import excecoes.DiametroInvalidoExcecao;
import excecoes.PesoInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;

import java.util.ArrayList;
import java.util.List;

public class PedidoTest {
    public static void main(String[] args) {
        
        
        List<Produto> produto1 = new ArrayList<Produto>();
        List<Produto> produto2 = new ArrayList<Produto>();        
        List<Produto> produto3 = new ArrayList<Produto>();
        List<Produto> produto4 = new ArrayList<Produto>();        
        List<Produto> produto5 = new ArrayList<Produto>();              
 
        try{
        Cliente cliente1 = new Cliente("diogo", "diogo@gmail.com", "31360100");
        System.out.println(cliente1);
        }catch(ClienteInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        try{
        Cliente cliente2 = new Cliente("maria", "maria@gmail.com", null);
        System.out.println(cliente2);
        }catch(ClienteInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
        
        try{
        Cliente cliente3 = new Cliente("ana", null, "35354540");
        System.out.println(cliente3);
        }catch(ClienteInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }  
        try{
        Cliente cliente4 = new Cliente(null, "bruno@bol.com.br", "45645645");
        System.out.println(cliente4);
        }catch(ClienteInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }
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
            Colar a1 = new Colar("Colar","355","189.90","2");
            a1.setModelo("ColarCravejadoZirconeo");
            a1.setPingente(false);
            a1.setPeso(125);
            System.out.println(a1);
            produto5.add(a1);
            System.out.println("preço dos objetos:"+ a1.calcularPreco());
        }catch(QuantidadeInvalidaExcecao | PesoInvalidoExcecao e){
            System.out.println("Erro nos dados:" + e.getMessage());
        }

        try{
            Pulseira pulseira3 = new Pulseira("Pulseira","457","109.90","-1");
            pulseira3.setModelo("PulseiraPataCao");
            pulseira3.setMaleavel(false);
            pulseira3.setPrendedor(true);
            produto5.add(pulseira3);
            produto4.add(pulseira3);
            }catch(QuantidadeInvalidaExcecao e){
                            System.out.println("error 404:" + e.getMessage());
            
            }
        
        try{
            Pulseira pulseira4 = new Pulseira("Pulseira","458","89.90","1");
            pulseira4.setModelo("PulseiraEstrelaDavi");
            pulseira4.setMaleavel(true);
            pulseira4.setPrendedor(false);
            produto5.add(pulseira4);
            produto4.add(pulseira4);

            }catch(QuantidadeInvalidaExcecao e){
                        System.out.println("error 404:" + e.getMessage());}

        try{
            Pulseira pulseira5 = new Pulseira("Pulseira","459","119.90","0");
            pulseira5.setModelo("PulseiraAncora");
            pulseira5.setMaleavel(false);
            pulseira5.setPrendedor(true);
            produto2.add(pulseira5);
            produto3.add(pulseira5);
            produto5.add(pulseira5);
        }catch(QuantidadeInvalidaExcecao e){
                    System.out.println("error 404:" + e.getMessage());}
    

        Pedido pedido01 = new Pedido();      
        pedido01.setCarrinho("anel,anel,colar");
        pedido01.setCodigoProduto("322");

        
        Pedido pedido02 = new Pedido();
        pedido02.setCarrinho("colar");
        pedido02.setCodigoProduto("555");

        
        Pedido pedido03 = new Pedido();
        pedido03.setCarrinho("colar,anel");
        pedido03.setCodigoProduto("800");

        
        Pedido pedido04 = new Pedido();
        pedido04.setCarrinho("colar,anel");
        pedido04.setCodigoProduto("800");

        
        Pedido pedido05 = new Pedido();
        pedido05.setCarrinho("colar,anel");
        pedido05.setCodigoProduto("800");

    }
}
