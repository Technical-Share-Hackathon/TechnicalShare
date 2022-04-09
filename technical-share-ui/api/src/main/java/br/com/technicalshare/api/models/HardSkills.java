package br.com.technicalshare.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "hard_skills")
public class HardSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHardSkills;

    @Column(name = "primeira_skill")
    private String primeiraHardSkill;

    @Column(name = "segunda_skill")
    private String segundaHardSkill;

    @Column(name = "terceira_skill")
    private String terceiraHardSkill;

    @Column(name = "quarta_skill")
    private String quartaHardSkill;

    @Column(name = "quinta_skill")
    private String quintaHardSkill;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Usuario usuario;

    public Long getIdHardSkills() {
        return idHardSkills;
    }

    public void setIdHardSkills(Long idHardSkills) {
        this.idHardSkills = idHardSkills;
    }

    public String getPrimeiraHardSkill() {
        return primeiraHardSkill;
    }

    public void setPrimeiraHardSkill(String primeiraHardSkill) {
        this.primeiraHardSkill = primeiraHardSkill;
    }

    public String getSegundaHardSkill() {
        return segundaHardSkill;
    }

    public void setSegundaHardSkill(String segundaHardSkill) {
        this.segundaHardSkill = segundaHardSkill;
    }

    public String getTerceiraHardSkill() {
        return terceiraHardSkill;
    }

    public void setTerceiraHardSkill(String terceiraHardSkill) {
        this.terceiraHardSkill = terceiraHardSkill;
    }

    public String getQuartaHardSkill() {
        return quartaHardSkill;
    }

    public void setQuartaHardSkill(String quartaHardSkill) {
        this.quartaHardSkill = quartaHardSkill;
    }

    public String getQuintaHardSkill() {
        return quintaHardSkill;
    }

    public void setQuintaHardSkill(String quintaHardSkill) {
        this.quintaHardSkill = quintaHardSkill;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
