package com.iscae._election_etudient.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Etudient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "INE", nullable = false, length = 12,unique = true)
    private String ine;
    @Basic
    @Column(name = "nom", nullable = false, length = 30)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 30)
    private String prenom;
    @Basic
    @Column(name = "date_naissance", nullable = true)
    private Date dateNaissance;
    @Basic
    @Column(name = "email", nullable = false, length = 100,unique = true)
    private String email;
    @Basic
    @Column(name = "numero_immatriculation", nullable = false, length = 15,unique = true)
    private String numeroImmatriculation;
    @Basic
    @Column(name = "niveau", nullable = false, length = 30)
    private String niveau;
    @Basic
    @Column(name = "etablisement", nullable = false, length = 300)
    private String etablisement;
    @Basic
    @Column(name = "est_vote", nullable = false)
    private Byte estVote=0;
    @Basic
    @Column(name = "FK_Election", nullable = false)
    private int fkElection;
    @OneToOne(mappedBy = "etudientByFkEtudient")
    private Candidat candidatsById;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "FK_Election", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    private Election electionByFkElection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public void setNumeroImmatriculation(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEtablisement() {
        return etablisement;
    }

    public void setEtablisement(String etablisement) {
        this.etablisement = etablisement;
    }

    public Byte getEstVote() {
        return estVote;
    }

    public void setEstVote(Byte estVote) {
        this.estVote = estVote;
    }

    public int getFkElection() {
        return fkElection;
    }

    public void setFkElection(int fkElection) {
        this.fkElection = fkElection;
    }

    public Candidat getCandidatsById() {
        return candidatsById;
    }

    public void setCandidatsById(Candidat candidatsById) {
        this.candidatsById = candidatsById;
    }

    public Election getElectionByFkElection() {
        return electionByFkElection;
    }

    public void setElectionByFkElection(Election electionByFkElection) {
        this.electionByFkElection = electionByFkElection;
    }
}
