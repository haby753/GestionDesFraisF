package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Visiteur;

@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

    @EntityGraph(attributePaths = {"fichesFrais"})
    List<Visiteur> findAll(); // Cette méthode chargera fichesFrais avec les visiteurs
    Optional<Visiteur> findById(Long id);
    Visiteur findByLogin(String login);
    Visiteur findByMdp(String mdp);
}