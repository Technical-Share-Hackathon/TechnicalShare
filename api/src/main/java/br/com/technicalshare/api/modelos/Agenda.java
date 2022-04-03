package br.com.technicalshare.api.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String segunda;

    private String terca;

    private String quarta;

    private String quinta;

    private String sexta;

    private String sabado;

    private LocalTime domingo;

}
