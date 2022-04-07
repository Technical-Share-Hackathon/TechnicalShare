package br.com.technicalshare.api.exception;

public class SemPermissaoException extends RuntimeException {

    private String mensagem;

    public SemPermissaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
