package br.com.technicalshare.api.controller.dto;

import br.com.technicalshare.api.models.Usuario;

public class UsuarioDtoSimples {

    private Long id;

    private String nome;

    private String linkFoto;

    private String profissaoAtual;

    private String resumo;

    public UsuarioDtoSimples(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.linkFoto =usuario.getLinkFoto();
        this.profissaoAtual = usuario.getProfissaoAtual();
        this.resumo = usuario.getResumo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public String getProfissaoAtual() {
        return profissaoAtual;
    }

    public String getResumo() {
        return resumo;
    }
}
