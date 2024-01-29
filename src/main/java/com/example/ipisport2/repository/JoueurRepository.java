package com.example.ipisport2.repository;

import com.example.ipisport2.dto.MaxPlayerDto;
import com.example.ipisport2.entities.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<JoueurEntity, Integer> {

    Integer countBySport(String sport);

    @Query(value = "Select CONCAT (name, ' ', firstname) as 'displayname', size from Joueurs where size in (select MAX(size) from Joueurs)", nativeQuery = true)
    MaxPlayerDto max();

    @Query(value = "Select top 1 CONCAT (name, ' ', firstname) as 'displayname', size from Joueurs where  sport = ?1  and gender = ?2 order by size", nativeQuery = true)
    MaxPlayerDto max2 (String Sport, String gender );




}
