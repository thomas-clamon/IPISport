package com.example.ipisport2.service;

import com.example.ipisport2.dto.ImputPlayerDto;
import com.example.ipisport2.dto.playerDto;
import com.example.ipisport2.entities.JoueurEntity;
import com.example.ipisport2.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class JoeurService implements IJoeurService{

    @Autowired
    private JoueurRepository repository;
    @Override
    public Boolean exist(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public playerDto toDto(JoueurEntity entity) {
        // traiter la données
        playerDto dto = new playerDto();
        String display_name = entity.getPrenom() + " " + entity.getNom();
        Integer age = Period.between(entity.getDate_naissance(), LocalDate.now()).getYears();

        // creer l'objet a envoyer
        dto.setDisplay(display_name);
        dto.setAge(age);
        dto.setSport(entity.getSport());
        return dto;
    }

    @Override
    public JoueurEntity get(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<JoueurEntity> getALL() {
        return repository.findAll();
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public JoueurEntity toEntity(ImputPlayerDto imputPlayerDto) {
        JoueurEntity joueurEntity = new JoueurEntity();
        joueurEntity.setNom(imputPlayerDto.getNom());
        joueurEntity.setPrenom(imputPlayerDto.getPrenom());
        joueurEntity.setDate_naissance(imputPlayerDto.getDate_naissance());
        joueurEntity.setTaille(imputPlayerDto.getTaille());
        joueurEntity.setPoid(imputPlayerDto.getPoid());
        joueurEntity.setSport(imputPlayerDto.getSport());
        joueurEntity.setGenre(imputPlayerDto.getGenre());
        return joueurEntity;
        }

    @Override
    public Integer add(ImputPlayerDto dto) {
        JoueurEntity entity = toEntity(dto);
        repository.saveAndFlush(entity);
        return entity.getID();
    }

    @Override
    public Float avgTaille(String sport) {
        // on recupere la liste de joueur
        List<JoueurEntity> list  = this.getALL();

        // on definit un compteur qui correspond au sport
        float bon_sport = 0;
        // on definit la somme
        float sum = 0;

        for (int i = 0; i<list.size(); i++){

            if (list.get(i).getSport().equals(sport)){
                bon_sport++;
                sum = sum + (float) list.get(i).getTaille();
            }
        }
        if (bon_sport == 0)
            return bon_sport;
        return sum/bon_sport;
    }

}
