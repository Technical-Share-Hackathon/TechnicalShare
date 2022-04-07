package br.com.technicalshare.api.controller.form;

import br.com.technicalshare.api.models.*;

public class UsuarioFormAtualizacao {

    private Long id;

    private String linkFoto;

    private String resumo;

    private SoftSkills softSkills;

    private HardSkills hardSkills;

    private AreaDeInteresse areaDeInteresse;

    private LinksDisponiveis linksDisponiveis;

    public Usuario converterParaEntidade(Usuario usuario) {
        usuario.setLinkFoto(this.getLinkFoto());
        usuario.setResumo(this.getResumo());
        usuario.setAreaDeInteresse(this.getAreaDeInteresse());
        usuario.setLinksDisponiveis(this.getLinksDisponiveis());
        usuario.setSoftSkills(this.getSoftSkills());
        usuario.setHardSkills(this.getHardSkills());

        return usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public SoftSkills getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(SoftSkills softSkills) {
        this.softSkills = softSkills;
    }

    public HardSkills getHardSkills() {
        return hardSkills;
    }

    public void setHardSkills(HardSkills hardSkills) {
        this.hardSkills = hardSkills;
    }

    public AreaDeInteresse getAreaDeInteresse() {
        return areaDeInteresse;
    }

    public void setAreaDeInteresse(AreaDeInteresse areaDeInteresse) {
        this.areaDeInteresse = areaDeInteresse;
    }

    public LinksDisponiveis getLinksDisponiveis() {
        return linksDisponiveis;
    }

    public void setLinksDisponiveis(LinksDisponiveis linksDisponiveis) {
        this.linksDisponiveis = linksDisponiveis;
    }
}
