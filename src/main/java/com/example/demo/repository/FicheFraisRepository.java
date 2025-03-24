package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FicheFrais;

import java.util.List;
@Repository
public interface FicheFraisRepository extends JpaRepository<FicheFrais, Long> {
    
    List<FicheFrais> findByVisiteurId(Long visiteurId);
    List<FicheFrais> findByMois(String mois);
    


}