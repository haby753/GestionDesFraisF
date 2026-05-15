package com.example.demo.service;

import com.example.demo.dto.LigneFraisHorsForfaitDTO;


import com.example.demo.entity.LigneFraisHorsForfait;

import com.example.demo.repository.FicheFraisRepository;
import com.example.demo.repository.VisiteurRepository;
import com.example.demo.repository.LigneFraisHorsForfaitRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LigneFraisHorsForfaitService {

    @Autowired
    private LigneFraisHorsForfaitRepository ligneFraisHorsForfaitRepository;

    @Autowired
    private FicheFraisRepository ficheFraisRepository;

    @Autowired
    private VisiteurRepository visiteurRepository;

    // ✅ Récupérer toutes les lignes
    public List<LigneFraisHorsForfaitDTO> getAllLignesFraisHorsForfait() {
        List<LigneFraisHorsForfait> lignes = ligneFraisHorsForfaitRepository.findAll();
        return lignes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Total pour le département 91 (existant)
    public Double getTotalMontantHorsForfaitPourDepartement91() {
        Double total = ligneFraisHorsForfaitRepository.getTotalMontantHorsForfaitPourDepartement91();
        return total != null ? total : 0.0;
    }

    // ✅ Récupérer une ligne par ID
    public LigneFraisHorsForfaitDTO getLigneFraisHorsForfaitById(Long id) {
        Optional<LigneFraisHorsForfait> ligne = ligneFraisHorsForfaitRepository.findById(id);
        return ligne.map(this::convertToDTO).orElse(null);
    }

    // ✅ Sauvegarder ou mettre à jour une ligne
    public LigneFraisHorsForfaitDTO saveLigneFraisHorsForfait(LigneFraisHorsForfaitDTO dto) {
        LigneFraisHorsForfait ligne = convertToEntity(dto);
        LigneFraisHorsForfait savedLigne = ligneFraisHorsForfaitRepository.save(ligne);
        return convertToDTO(savedLigne);
    }

    // ✅ Supprimer une ligne
    public void deleteLigneFraisHorsForfait(Long id) {
        ligneFraisHorsForfaitRepository.deleteById(id);
    }

    // 🔁 Conversion vers DTO
    private LigneFraisHorsForfaitDTO convertToDTO(LigneFraisHorsForfait ligne) {
        LigneFraisHorsForfaitDTO dto = new LigneFraisHorsForfaitDTO();
        dto.setId(ligne.getId());
        dto.setMontant(ligne.getMontant());
        dto.setDescription(ligne.getDescription());
        dto.setDate(ligne.getDate());

        if (ligne.getFicheFrais() != null) {
            dto.setFicheFraisId(ligne.getFicheFrais().getId());
        }

        if (ligne.getIdvisiteur() != null) {
            dto.setVisiteurId(ligne.getIdvisiteur().getId());
        }

        return dto;
    }

    // 🔁 Conversion vers Entity
    private LigneFraisHorsForfait convertToEntity(LigneFraisHorsForfaitDTO dto) {
        LigneFraisHorsForfait ligne = new LigneFraisHorsForfait();
        ligne.setId(dto.getId());
        ligne.setMontant(dto.getMontant());
        ligne.setDescription(dto.getDescription());
        ligne.setDate(dto.getDate());

        if (dto.getFicheFraisId() != null) {
            ficheFraisRepository.findById(dto.getFicheFraisId()).ifPresent(ligne::setFicheFrais);
        }

        if (dto.getVisiteurId() != null) {
            visiteurRepository.findById(dto.getVisiteurId()).ifPresent(ligne::setVisiteur);
        }

        return ligne;
    }
}
