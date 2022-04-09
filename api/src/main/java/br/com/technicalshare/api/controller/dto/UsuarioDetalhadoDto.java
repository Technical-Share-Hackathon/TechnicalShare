package br.com.technicalshare.api.controller.dto;

import br.com.technicalshare.api.models.*;

public class UsuarioDetalhadoDto {

    private Long id;

    private String nome;

    private String linkFoto;

    private String profissaoAtual;

    private String resumo;

    private String email;

    private SoftSkills softSkills;

    private HardSkills hardSkills;

    private AreaDeInteresse areaDeInteresse;

    private LinksDisponiveis linksDisponiveis;

    public UsuarioDetalhadoDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.linkFoto = usuario.getLinkFoto();
        this.profissaoAtual = usuario.getProfissaoAtual();
        this.resumo = usuario.getResumo();
        this.email = usuario.getEmail();
        this.linksDisponiveis = usuario.getLinksDisponiveis();
        this.softSkills = usuario.getSoftSkills();
        this.hardSkills = usuario.getHardSkills();
        this.areaDeInteresse = usuario.getAreaDeInteresse();
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

    public String getEmail() {
        return email;
    }

    public SoftSkills getSoftSkills() {
        return softSkills;
    }

    public HardSkills getHardSkills() {
        return hardSkills;
    }

    public AreaDeInteresse getAreaDeInteresse() {
        return areaDeInteresse;
    }

    public LinksDisponiveis getLinksDisponiveis() {
        return linksDisponiveis;
    }
}
