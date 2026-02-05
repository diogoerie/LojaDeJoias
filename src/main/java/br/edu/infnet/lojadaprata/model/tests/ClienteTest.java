package br.edu.infnet.lojadaprata.model.tests;

import br.edu.infnet.lojadaprata.model.domain.Cliente;
import excecoes.ClienteInvalidoExcecao;


public class ClienteTest {
    public static void main(String[] args) {
        
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
    }
}
