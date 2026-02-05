package excecoes;


public class DiametroInvalidoExcecao extends Exception {

    
    private static final long serialVersionUID= 1L;
    
    public DiametroInvalidoExcecao(String mensagemErro){
        super(mensagemErro);
    }
}
