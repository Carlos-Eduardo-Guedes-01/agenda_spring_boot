package com.evento.eventoapp.models;

import java.time.LocalDateTime;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Candidaturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuarios usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idevento", nullable = false)
    private Eventos evento;

    public Candidaturas() {

    }

    public Candidaturas(Usuarios usuario, Eventos evento, LocalDateTime dataCandidatura) {
        this.usuario = usuario;
        this.evento = evento;
        this.dataCandidatura = dataCandidatura;
    }

    private LocalDateTime dataCandidatura;

    public LocalDateTime getDataCandidatura() {
        return dataCandidatura;
    }

    public void setDataCandidatura(LocalDateTime dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }

    // getters, setters, construtores
}
