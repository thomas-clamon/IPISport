package com.example.ipisport2.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class ImputPlayerDto {

    private String nom;

    private String prenom;
    private LocalDate date_naissance;

    private Integer taille;
    private Integer poid;
    private String sport;
    private String genre;

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
}
