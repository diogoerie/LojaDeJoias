package excecoes;


public class TamanhoInvalidoExcecao extends Exception {

    
    private static final long serialVersionUID= 1L;
    
    public TamanhoInvalidoExcecao(String mensagemErro){
        super(mensagemErro);
    }
}
