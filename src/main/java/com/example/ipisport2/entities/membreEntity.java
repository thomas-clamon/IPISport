package com.example.ipisport2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Membres")
public class membreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "date_inscription")
    private LocalDate date_inscription;

    @Column (name = "date_fin")
    private LocalDate date_fin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_club")
    private ClubEntity clubEntity;

}
