package br.com.technicalshare.api.exception;

public class UsuarioNaoExistenteException extends RuntimeException {

    private String mensagem;

    public UsuarioNaoExistenteException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
