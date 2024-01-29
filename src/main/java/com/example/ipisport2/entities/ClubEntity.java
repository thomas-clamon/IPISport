package com.example.ipisport2.entities;

import com.example.ipisport2.enumeration.Sport;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clubs")
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" )
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column (name = "budget")
    private Integer budget;

    @Column(name = "sport")
    private String sport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
