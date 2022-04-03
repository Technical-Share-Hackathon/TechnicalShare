package br.com.technicalshare.api.modelos;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private boolean mentor;

    @Column(name = "media_avaliacao")
    private int mediaAvaliacao;

    private String[] linksDisponiveis;

    @OneToOne
    private Agenda agenda;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", mentor=" + mentor +
                ", mediaAvaliacao=" + mediaAvaliacao +
                ", linksDisponiveis=" + Arrays.toString(linksDisponiveis) +
                ", agenda=" + agenda +
                '}';
    }

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

    public boolean isMentor() {
        return mentor;
    }

    public void setMentor(boolean mentor) {
        this.mentor = mentor;
    }

    public int getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    public void setMediaAvaliacao(int mediaAvaliacao) {
        this.mediaAvaliacao = mediaAvaliacao;
    }

    public String[] getLinksDisponiveis() {
        return linksDisponiveis;
    }

    public void setLinksDisponiveis(String[] linksDisponiveis) {
        this.linksDisponiveis = linksDisponiveis;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
