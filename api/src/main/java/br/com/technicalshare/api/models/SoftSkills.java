package br.com.technicalshare.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "soft_skills")
public class SoftSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoftSkills;

    @Column(name = "primeira_skill")
    private String primeiraSoftSkill;

    @Column(name = "segunda_skill")
    private String segundaSoftSkill;

    @Column(name = "terceira_skill")
    private String terceiraSoftSkill;

    @Column(name = "quarta_skill")
    private String quartaSoftSkill;

    @Column(name = "quinta_skill")
    private String quintaSoftSkill;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Usuario usuario;

    public Long getIdSoftSkills() {
        return idSoftSkills;
    }

    public void setIdSoftSkills(Long idSoftSkills) {
        this.idSoftSkills = idSoftSkills;
    }

    public String getPrimeiraSoftSkill() {
        return primeiraSoftSkill;
    }

    public void setPrimeiraSoftSkill(String primeiraSoftSkill) {
        this.primeiraSoftSkill = primeiraSoftSkill;
    }

    public String getSegundaSoftSkill() {
        return segundaSoftSkill;
    }

    public void setSegundaSoftSkill(String segundaSoftSkill) {
        this.segundaSoftSkill = segundaSoftSkill;
    }

    public String getTerceiraSoftSkill() {
        return terceiraSoftSkill;
    }

    public void setTerceiraSoftSkill(String terceiraSoftSkill) {
        this.terceiraSoftSkill = terceiraSoftSkill;
    }

    public String getQuartaSoftSkill() {
        return quartaSoftSkill;
    }

    public void setQuartaSoftSkill(String quartaSoftSkill) {
        this.quartaSoftSkill = quartaSoftSkill;
    }

    public String getQuintaSoftSkill() {
        return quintaSoftSkill;
    }

    public void setQuintaSoftSkill(String quintaSoftSkill) {
        this.quintaSoftSkill = quintaSoftSkill;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
