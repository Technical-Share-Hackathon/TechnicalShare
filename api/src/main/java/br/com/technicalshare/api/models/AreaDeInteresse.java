package br.com.technicalshare.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "interesses")
public class AreaDeInteresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInteresses;

    @Column(name = "primeiro_interesse")
    private String primeiraAreaDeInteresse;

    @Column(name = "segundo_interesse")
    private String segundaAreaDeInteresse;

    @Column(name = "terceiro_interesse")
    private String terceiraAreaDeInteresse;

    @Column(name = "quarto_interesse")
    private String quartaAreaDeInteresse;

    @Column(name = "quinto_interesse")
    private String quintaAreaDeInteresse;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Usuario usuario;

    public Long getIdInteresses() {
        return idInteresses;
    }

    public void setIdInteresses(Long idInteresses) {
        this.idInteresses = idInteresses;
    }

    public String getPrimeiraAreaDeInteresse() {
        return primeiraAreaDeInteresse;
    }

    public void setPrimeiraAreaDeInteresse(String primeiraAreaDeInteresse) {
        this.primeiraAreaDeInteresse = primeiraAreaDeInteresse;
    }

    public String getSegundaAreaDeInteresse() {
        return segundaAreaDeInteresse;
    }

    public void setSegundaAreaDeInteresse(String segundaAreaDeInteresse) {
        this.segundaAreaDeInteresse = segundaAreaDeInteresse;
    }

    public String getTerceiraAreaDeInteresse() {
        return terceiraAreaDeInteresse;
    }

    public void setTerceiraAreaDeInteresse(String terceiraAreaDeInteresse) {
        this.terceiraAreaDeInteresse = terceiraAreaDeInteresse;
    }

    public String getQuartaAreaDeInteresse() {
        return quartaAreaDeInteresse;
    }

    public void setQuartaAreaDeInteresse(String quartaAreaDeInteresse) {
        this.quartaAreaDeInteresse = quartaAreaDeInteresse;
    }

    public String getQuintaAreaDeInteresse() {
        return quintaAreaDeInteresse;
    }

    public void setQuintaAreaDeInteresse(String quintaAreaDeInteresse) {
        this.quintaAreaDeInteresse = quintaAreaDeInteresse;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
