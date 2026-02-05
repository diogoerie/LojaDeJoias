package excecoes;


public class AquivoExcecao extends Exception {

    
    private static final long serialVersionUID= 1L;
    
    public AquivoExcecao(String mensagemErro){
        super(mensagemErro);
    }
}
