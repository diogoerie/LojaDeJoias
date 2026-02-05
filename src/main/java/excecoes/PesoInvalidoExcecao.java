package excecoes;


public class PesoInvalidoExcecao extends Exception {

    
    private static final long serialVersionUID= 1L;
    
    public PesoInvalidoExcecao(String mensagemErro){
        super(mensagemErro);
    }
}
