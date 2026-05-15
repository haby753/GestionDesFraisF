package com.example.demo;



import com.example.demo.entity.Visiteur;
import com.example.demo.repository.VisiteurRepository;
import com.example.demo.entity.FicheFrais;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


@SpringBootTest(properties = "spring.config.name=application-test")
class VisiteurRepositoryTest {

    @Autowired
    private VisiteurRepository visiteurRepository;

    @BeforeEach
    void setUp() {
        // Création et sauvegarde de visiteurs avec fichesFrais
        Visiteur visiteur = new Visiteur();
        visiteur.setNom("Dupont");
        visiteur.setPrenom("Jean");

        FicheFrais fiche1 = new FicheFrais();
        fiche1.setMois("202401");
        fiche1.setVisiteur(visiteur);

        FicheFrais fiche2 = new FicheFrais();
        fiche2.setMois("202402");
        fiche2.setVisiteur(visiteur);

      //  visiteur.setFichesFrais(List.of(fiche1, fiche2));

        visiteurRepository.save(visiteur);
    }

    @AfterEach
    void tearDown() {
        visiteurRepository.deleteAll();
    }

    @Test
    void testFindAllWithFichesFrais() {
        List<Visiteur> visiteurs = visiteurRepository.findAll();

        assertNotNull(visiteurs);
        assertEquals(1, visiteurs.size());
        assertEquals("Dupont", visiteurs.get(0).getNom());

      
    //    assertNotNull(visiteurs.get(0).getFichesFrais());
       // assertEquals(2, visiteurs.get(0).getFichesFrais().size());
    }
}
