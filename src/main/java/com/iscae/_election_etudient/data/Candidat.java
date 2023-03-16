package com.iscae._election_etudient.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Candidat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "FK_Etudient", nullable = false)
    private int fkEtudient;
    @Basic
    @Column(name = "FK_Syndicat", nullable = false)
    private int fkSyndicat;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "FK_Etudient", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Etudient etudientByFkEtudient;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "FK_Syndicat", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Syndicat syndicatByFkSyndicat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkEtudient() {
        return fkEtudient;
    }

    public void setFkEtudient(int fkEtudient) {
        this.fkEtudient = fkEtudient;
    }

    public int getFkSyndicat() {
        return fkSyndicat;
    }

    public void setFkSyndicat(int fkSyndicat) {
        this.fkSyndicat = fkSyndicat;
    }

    public Etudient getEtudientByFkEtudient() {
        return etudientByFkEtudient;
    }

    public void setEtudientByFkEtudient(Etudient etudientByFkEtudient) {
        this.etudientByFkEtudient = etudientByFkEtudient;
    }

    public Syndicat getSyndicatByFkSyndicat() {
        return syndicatByFkSyndicat;
    }

    public void setSyndicatByFkSyndicat(Syndicat syndicatByFkSyndicat) {
        this.syndicatByFkSyndicat = syndicatByFkSyndicat;
    }
}
