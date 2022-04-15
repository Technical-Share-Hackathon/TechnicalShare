package br.com.technicalshare.api.controller.dto;

import br.com.technicalshare.api.models.*;

import java.util.List;

public class UsuarioDetalhadoDto {

    private Long id;

    private String nome;

    private String linkFoto;

    private String profissaoAtual;

    private String squad;

    private String nivelSenioridade;

    private String resumo;

    private String email;

    private String localizacao;

    private SoftSkills softSkills;

    private HardSkills hardSkills;

    private AreaDeInteresse areaDeInteresse;

    private LinksDisponiveis linksDisponiveis;

    private List<Experiencia> experiencias;

    public UsuarioDetalhadoDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.linkFoto = usuario.getLinkFoto();
        this.profissaoAtual = usuario.getProfissaoAtual();
        this.resumo = usuario.getResumo();
        this.email = usuario.getEmail();
        this.localizacao = usuario.getLocalizacao();
        this.linksDisponiveis = usuario.getLinksDisponiveis();
        this.softSkills = usuario.getSoftSkills();
        this.hardSkills = usuario.getHardSkills();

        this.areaDeInteresse = usuario.getAreaDeInteresse() != null ?
                usuario.getAreaDeInteresse() :  new AreaDeInteresse();

        this.experiencias = usuario.getExperiencias();
        this.nivelSenioridade = usuario.getNivelSenioridade();
        this.squad = usuario.getSquad();
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

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public String getSquad() {
        return squad;
    }

    public String getNivelSenioridade() {
        return nivelSenioridade;
    }
}
