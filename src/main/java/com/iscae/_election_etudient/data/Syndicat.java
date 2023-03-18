package com.iscae._election_etudient.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Syndicat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "syndicat_nom", nullable = false, length = 100)
    private String syndicatNom;
    @Basic
    @Column(name = "nombre_vote", nullable = false)
    private int nombreVote=0;
    @Basic
    @Column(name = "FK_Election", nullable = false)
    private int fkElection;
    @Basic
    @Column(name = "logo", nullable = false, length = 100)
    private String logo;
    @OneToMany(mappedBy = "syndicatByFkSyndicat")
    private Collection<Candidat> candidatsById;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "FK_Election", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Election electionByFkElection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSyndicatNom() {
        return syndicatNom;
    }

    public void setSyndicatNom(String syndicatNom) {
        this.syndicatNom = syndicatNom;
    }

    public int getNombreVote() {
        return nombreVote;
    }

    public void setNombreVote(int nombreVote) {
        this.nombreVote = nombreVote;
    }

    public int getFkElection() {
        return fkElection;
    }

    public void setFkElection(int fkElection) {
        this.fkElection = fkElection;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Collection<Candidat> getCandidatsById() {
        return candidatsById;
    }

    public void setCandidatsById(Collection<Candidat> candidatsById) {
        this.candidatsById = candidatsById;
    }

    public Election getElectionByFkElection() {
        return electionByFkElection;
    }

    public void setElectionByFkElection(Election electionByFkElection) {
        this.electionByFkElection = electionByFkElection;
    }
}
