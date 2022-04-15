package br.com.technicalshare.api.exception.dto;

public class ExceptionDto {

    private String erro;

    public ExceptionDto(String mensagem) {
        this.erro = mensagem;
    }

    public String getErro() {
        return erro;
    }
}
