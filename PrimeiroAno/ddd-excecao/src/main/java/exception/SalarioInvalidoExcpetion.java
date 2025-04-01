package exception;

public class SalarioInvalidoExcpetion extends RuntimeException{
    static final long serialVersionUID = 1L;
    public SalarioInvalidoExcpetion(String mensagem){
        super(mensagem);
    }
}
