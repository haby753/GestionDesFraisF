package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FraisForfait;
@Repository
public interface FraisForfaitRepository extends JpaRepository<FraisForfait, Long> {
    
    FraisForfait findByLibelle(String libelle);
    
    @Query("SELECT SUM(l.quantite * f.montant) FROM LigneFraisForfait l JOIN l.fraisForfait f WHERE l.ficheFrais.visiteur.cp LIKE '91%'")
    Double getTotalMontantForfaitPourDepartement91();
}