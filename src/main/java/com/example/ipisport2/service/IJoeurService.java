package com.example.ipisport2.service;

import com.example.ipisport2.dto.ImputPlayerDto;
import com.example.ipisport2.dto.MaxPlayerDto;
import com.example.ipisport2.dto.playerDto;
import com.example.ipisport2.entities.JoueurEntity;

import java.util.List;

public interface IJoeurService {

    Boolean exist(Integer id); // verifie si le jouer avec l'ID id existe

    playerDto toDto (JoueurEntity entity); // convertie l'entit" en dto

    JoueurEntity get(Integer id);

    List<JoueurEntity> getALL();

    Boolean delete (Integer id);

    JoueurEntity toEntity(ImputPlayerDto dto);

    Integer add (ImputPlayerDto dto);

    Float avgTaille(String sport);

    Integer counMenber(String sport);

    MaxPlayerDto maxTaille ();

    MaxPlayerDto maxTaille(String sport, String genre);

}
