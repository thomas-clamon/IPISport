package com.example.ipisport2.repository;

import com.example.ipisport2.entities.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<JoueurEntity, Integer> {
}
