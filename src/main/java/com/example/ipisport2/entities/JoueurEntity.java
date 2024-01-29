package com.example.ipisport2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Joueurs")
public class JoueurEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "name")
    private String nom;

    @Column(name = "firstname")
    private String prenom;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Membres",
            joinColumns = @JoinColumn(name = "id_membre", referencedColumnName ="ID"),
            inverseJoinColumns = @JoinColumn(name = "id_club", referencedColumnName = "ID")
            )
    private List<ClubEntity> clubEntities;

    @Column(name = "birth_date")
    private LocalDate date_naissance;


    @Column(name = "size")
    private Integer taille;


    @Column(name = "weight")
    private Integer poid;

    @Column(name = "sport")
    private String sport;

    @Column(name = "gender")
    private String genre;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public Integer getPoid() {
        return poid;
    }

    public void setPoid(Integer poid) {
        this.poid = poid;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<ClubEntity> getClubEntities() {
        return clubEntities;
    }

    public void setClubEntities(List<ClubEntity> clubEntities) {
        this.clubEntities = clubEntities;
    }
}
