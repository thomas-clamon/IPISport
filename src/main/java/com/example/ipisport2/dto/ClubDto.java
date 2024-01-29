package com.example.ipisport2.dto;

public class ClubDto {

    private String nom;
    private Integer budget;

    private String Sport;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String sport) {
        Sport = sport;
    }
}
