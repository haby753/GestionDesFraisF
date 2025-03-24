package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LigneFraisForfait;

import java.util.List;
@Repository
public interface LigneFraisForfaitRepository extends JpaRepository<LigneFraisForfait, Long> {
    
    List<LigneFraisForfait> findByFicheFraisId(Long ficheFraisId);
}