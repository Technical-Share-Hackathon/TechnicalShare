package br.com.technicalshare.api.models;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class LinksDisponiveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link_whatsapp")
    private String linkWhats;

    @Column(name = "link_teams")
    private String linkTeams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkWhats() {
        return linkWhats;
    }

    public void setLinkWhats(String linkWhats) {
        this.linkWhats = linkWhats;
    }

    public String getLinkTeams() {
        return linkTeams;
    }

    public void setLinkTeams(String linkTeams) {
        this.linkTeams = linkTeams;
    }
}
