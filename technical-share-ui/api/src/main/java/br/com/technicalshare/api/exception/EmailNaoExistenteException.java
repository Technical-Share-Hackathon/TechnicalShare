package br.com.technicalshare.api.exception;

public class EmailNaoExistenteException extends RuntimeException {

    private String mensagem;

    public EmailNaoExistenteException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
