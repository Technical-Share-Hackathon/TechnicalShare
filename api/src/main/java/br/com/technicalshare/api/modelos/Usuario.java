package br.com.technicalshare.api.modelos;

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

    private String descricao;

    private String email;

    private String senha;

    @OneToOne
    @JoinColumn(name = "links_id")
    private LinksDisponiveis linksDisponiveis;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LinksDisponiveis getLinksDisponiveis() {
        return linksDisponiveis;
    }

    public void setLinksDisponiveis(LinksDisponiveis linksDisponiveis) {
        this.linksDisponiveis = linksDisponiveis;
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
