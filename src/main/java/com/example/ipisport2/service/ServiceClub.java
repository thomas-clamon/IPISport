package com.example.ipisport2.service;

import com.example.ipisport2.dto.ClubDto;
import com.example.ipisport2.entities.ClubEntity;
import com.example.ipisport2.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClub implements IServiceClub {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public Integer addClub(ClubDto dto) {
        ClubEntity entity = new ClubEntity();
        entity.setNom(dto.getNom());
        entity.setBudget(dto.getBudget());
        entity.setSport(dto.getSport());
        clubRepository.saveAndFlush(entity);
        return entity.getId();
    }
}
