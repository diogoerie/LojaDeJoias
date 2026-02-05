package excecoes;


public class ClienteInvalidoExcecao extends Exception {

    
    private static final long serialVersionUID= 1L;
    
    public ClienteInvalidoExcecao(String mensagemErro){
        super(mensagemErro);
    }
}
