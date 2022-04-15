package br.com.technicalshare.api.controller.form;

public class UsuarioFormLogin {

    private String email;
    private String senha;

    public UsuarioFormLogin() {
    }

    public UsuarioFormLogin(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


}
