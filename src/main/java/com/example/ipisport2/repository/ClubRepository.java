package com.example.ipisport2.repository;

import com.example.ipisport2.entities.ClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository <ClubEntity, Integer>{
}
