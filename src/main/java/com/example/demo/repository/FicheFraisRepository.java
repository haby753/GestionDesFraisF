package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FicheFrais;

import java.util.List;
import java.util.Optional;
@Repository
public interface FicheFraisRepository extends JpaRepository<FicheFrais, Long> {
    
    List<FicheFrais> findByVisiteurId(Long visiteurId);
    List<FicheFrais> findByMois(String mois);
    Optional<FicheFrais> findById(Long id);
    


}