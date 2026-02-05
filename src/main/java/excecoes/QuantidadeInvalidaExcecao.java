package excecoes;


public class QuantidadeInvalidaExcecao extends Exception {

    
    private static final long serialVersionUID= 1L;
    
    public QuantidadeInvalidaExcecao(String mensagemErro){
        super(mensagemErro);
    }
}
