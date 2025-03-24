package com.example.demo.service;

import com.example.demo.dto.VisiteurDTO;
import com.example.demo.entity.Visiteur;
import com.example.demo.repository.VisiteurRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.Hibernate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class VisiteurService {

    @Autowired
    private VisiteurRepository visiteurRepository;

   

    public List<VisiteurDTO> getAllVisiteurs() {
        List<Visiteur> visiteurs = visiteurRepository.findAll();
        visiteurs.forEach(visiteur -> Hibernate.initialize(visiteur.getFichesFrais())); // Initialise la collection
        return visiteurs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VisiteurDTO getVisiteurById(Long id) {
        Optional<Visiteur> visiteur = visiteurRepository.findById(id);
        return visiteur.map(this::convertToDTO).orElse(null);
    }

    public VisiteurDTO saveVisiteur(VisiteurDTO visiteurDTO) {
        Visiteur visiteur = convertToEntity(visiteurDTO);
        Visiteur savedVisiteur = visiteurRepository.save(visiteur);
        return convertToDTO(savedVisiteur);
    }

    public void deleteVisiteur(Long id) {
        visiteurRepository.deleteById(id);
    }

    private VisiteurDTO convertToDTO(Visiteur visiteur) {
        VisiteurDTO dto = new VisiteurDTO();
        dto.setId(visiteur.getId());
        dto.setNom(visiteur.getNom());
        dto.setPrenom(visiteur.getPrenom());
        dto.setAdresse(visiteur.getAdresse());
        dto.setVille(visiteur.getVille());
        dto.setCp(visiteur.getCp());
        dto.setLogin(visiteur.getLogin());
        dto.setMdp(visiteur.getMdp());
        dto.setDateEmbauche(visiteur.getDateEmbauche()); // Pas de conversion nécessaire
      //  dto.setFichesFrais(visiteur.getFichesFrais() != null ?
             //   visiteur.getFichesFrais().stream()
               // .map(ficheFrais -> ficheFrais.getMois())
              //  .collect(Collectors.toList()) : null);
        return dto;
    }

    private Visiteur convertToEntity(VisiteurDTO dto) {
        Visiteur visiteur = new Visiteur();
        visiteur.setId(dto.getId());
        visiteur.setNom(dto.getNom());
        visiteur.setPrenom(dto.getPrenom());
        visiteur.setAdresse(dto.getAdresse());
        visiteur.setVille(dto.getVille());
        visiteur.setCp(dto.getCp());
        visiteur.setLogin(dto.getLogin());
        visiteur.setMdp(dto.getMdp());
        visiteur.setDateEmbauche(dto.getDateEmbauche()); // Pas de conversion nécessaire
        return visiteur;
    }}