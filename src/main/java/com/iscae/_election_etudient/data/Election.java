package com.iscae._election_etudient.data;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;

@Entity
public class Election {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date_Debit", nullable = true)
    private Date dateDebit=Date.from(Instant.now());
    @Basic
    @Column(name = "date_Fin", nullable = false)
    private Date dateFin;
    @Basic
    @Column(name = "sujet", nullable = false, length = 50,unique = true)
    private String sujet;
    @Basic
    @Column(name = "nombre_inscrits", nullable = false)
    private int nombreInscrits=0;
    @OneToMany(mappedBy = "electionByFkElection")
    private Collection<Etudient> etudientsById;
    @OneToMany(mappedBy = "electionByFkElection")
    private Collection<Syndicat> syndicatsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebit() {
        return dateDebit;
    }

    public void setDateDebit(Date dateDebit) {
        this.dateDebit = dateDebit;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getNombreInscrits() {
        return nombreInscrits;
    }

    public void setNombreInscrits(int nombreInscrits) {
        this.nombreInscrits = nombreInscrits;
    }

    public Collection<Etudient> getEtudientsById() {
        return etudientsById;
    }

    public void setEtudientsById(Collection<Etudient> etudientsById) {
        this.etudientsById = etudientsById;
    }

    public Collection<Syndicat> getSyndicatsById() {
        return syndicatsById;
    }

    public void setSyndicatsById(Collection<Syndicat> syndicatsById) {
        this.syndicatsById = syndicatsById;
    }
}
