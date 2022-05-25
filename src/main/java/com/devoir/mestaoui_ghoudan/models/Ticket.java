package com.devoir.mestaoui_ghoudan.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String urgence;
    private String environnement;
    private String logiciel;
    private String statut;
    @JsonBackReference
    @ManyToOne
    private Developpeur developpeur;
    @ManyToOne
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrgence() {
        return urgence;
    }

    public void setUrgence(String urgence) {
        this.urgence = urgence;
    }

    public String getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(String environnement) {
        this.environnement = environnement;
    }

    public String getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(String logiciel) {
        this.logiciel = logiciel;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Developpeur getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(Developpeur developpeur) {
        this.developpeur = developpeur;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
