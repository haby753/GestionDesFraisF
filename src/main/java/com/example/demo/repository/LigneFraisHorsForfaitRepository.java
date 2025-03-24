package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LigneFraisHorsForfait;

import java.util.List;
@Repository
public interface LigneFraisHorsForfaitRepository extends JpaRepository<LigneFraisHorsForfait, Long> {
 
    List<LigneFraisHorsForfait> findByFicheFraisId(Long ficheFraisId);
    
    @Query("SELECT SUM(l.montant) FROM LigneFraisHorsForfait l WHERE l.ficheFrais.visiteur.cp LIKE '91%'")
    Double getTotalMontantHorsForfaitPourDepartement91();
}