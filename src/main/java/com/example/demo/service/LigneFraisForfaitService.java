package com.example.demo.service;
import com.example.demo.entity.LigneFraisForfait;

import com.example.demo.repository.LigneFraisForfaitRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import com.example.demo.dto.LigneFraisForfaitDTO;


import java.util.stream.Collectors;




@Transactional
@Service
public class LigneFraisForfaitService {

    @Autowired
    private LigneFraisForfaitRepository ligneFraisForfaitRepository;

    // Récupérer toutes les lignes de frais forfait
    public List<LigneFraisForfaitDTO> getAllLignesFraisForfait() {
        List<LigneFraisForfait> lignes = ligneFraisForfaitRepository.findAll();
        return lignes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Récupérer une ligne par son ID
    public LigneFraisForfaitDTO getLigneFraisForfaitById(Long id) {
        LigneFraisForfait ligne = ligneFraisForfaitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ligne non trouvée avec l'ID : " + id));
        return convertToDTO(ligne);
    }

    // Enregistrer une nouvelle ligne ou mettre à jour une ligne existante
    public LigneFraisForfaitDTO saveLigneFraisForfait(LigneFraisForfaitDTO dto) {
        LigneFraisForfait ligne = convertToEntity(dto);
        LigneFraisForfait savedLigne = ligneFraisForfaitRepository.save(ligne);
        return convertToDTO(savedLigne);
    }

    // Supprimer une ligne par son ID
    public void deleteLigneFraisForfait(Long id) {
        if (!ligneFraisForfaitRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : Ligne non trouvée avec l'ID : " + id);
        }
        ligneFraisForfaitRepository.deleteById(id);
    }

    // Méthode pour convertir Entity en DTO
    private LigneFraisForfaitDTO convertToDTO(LigneFraisForfait entity) {
        LigneFraisForfaitDTO dto = new LigneFraisForfaitDTO();
        dto.setId(entity.getId());
        dto.setQuantite(entity.getQuantite());
        
        return dto;
    }

    // Méthode pour convertir DTO en Entity
    private LigneFraisForfait convertToEntity(LigneFraisForfaitDTO dto) {
        LigneFraisForfait entity = new LigneFraisForfait();
        entity.setId(dto.getId());
        entity.setQuantite(dto.getQuantite());
        // Gestion de la relation avec FicheFrais et FraisForfait
        
        
        
       
        return entity;
    }
}