package br.com.technicalshare.api.modelos;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class LinksDisponiveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primeiro_link")
    private String primeiroLink;

    @Column(name = "segundo_link")
    private String segundoLink;

    @Column(name = "terceiro_link")
    private String terceiroLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroLink() {
        return primeiroLink;
    }

    public void setPrimeiroLink(String primeiroLink) {
        this.primeiroLink = primeiroLink;
    }

    public String getSegundoLink() {
        return segundoLink;
    }

    public void setSegundoLink(String segundoLink) {
        this.segundoLink = segundoLink;
    }

    public String getTerceiroLink() {
        return terceiroLink;
    }

    public void setTerceiroLink(String terceiroLink) {
        this.terceiroLink = terceiroLink;
    }
}
