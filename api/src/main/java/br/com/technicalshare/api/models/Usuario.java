package br.com.technicalshare.api.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "link_foto")
    private String linkFoto;

    @Column(name = "profissao_atual")
    private String profissaoAtual;

    private String resumo;

    private String email;

    private String senha;

    @OneToOne
    @JoinColumn(name = "links_id")
    private LinksDisponiveis linksDisponiveis;

    @OneToOne
    @JoinColumn(name = "soft_skills_id")
    private SoftSkills softSkills;

    @OneToOne
    @JoinColumn(name = "hard_skills_id")
    private HardSkills hardSkills;

    @OneToOne
    @JoinColumn(name = "interesses_id")
    private AreaDeInteresse areaDeInteresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public String getProfissaoAtual() {
        return profissaoAtual;
    }

    public void setProfissaoAtual(String profissaoAtual) {
        this.profissaoAtual = profissaoAtual;
    }

    public LinksDisponiveis getLinksDisponiveis() {
        return linksDisponiveis;
    }

    public void setLinksDisponiveis(LinksDisponiveis linksDisponiveis) {
        this.linksDisponiveis = linksDisponiveis;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
