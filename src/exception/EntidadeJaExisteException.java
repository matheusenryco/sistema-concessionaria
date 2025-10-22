package exception;

public class EntidadeJaExisteException extends RuntimeException {
    public EntidadeJaExisteException(String mensagem) {
        super(mensagem);
    }
}

