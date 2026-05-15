package com.example.demo.service;

import com.example.demo.dto.FraisForfaitDTO;
import com.example.demo.entity.FraisForfait;
import com.example.demo.repository.FraisForfaitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FraisForfaitService {

    @Autowired
    private FraisForfaitRepository fraisForfaitRepository;

    // ✅ Récupérer tous les frais forfaitaires
    public List<FraisForfaitDTO> getAllFraisForfait() {
        List<FraisForfait> fraisForfaits = fraisForfaitRepository.findAll();
        return fraisForfaits.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Récupérer un frais forfaitaire par ID
    public Optional<FraisForfaitDTO> getFraisForfaitById(Long id) {
        return fraisForfaitRepository.findById(id).map(this::convertToDTO);
    }

    // ✅ Enregistrer ou mettre à jour un frais forfaitaire
    public FraisForfaitDTO saveFraisForfait(FraisForfaitDTO dto) {
        FraisForfait fraisForfait = convertToEntity(dto);
        FraisForfait savedFraisForfait = fraisForfaitRepository.save(fraisForfait);
        return convertToDTO(savedFraisForfait);
    }

    // ✅ Supprimer un frais forfaitaire par ID
    public void deleteFraisForfait(Long id) {
        fraisForfaitRepository.deleteById(id);
    }

    // ✅ Calculer le total des frais forfaitaires
    public Double getTotalMontantFraisForfait() {
        return fraisForfaitRepository.findAll()
                .stream()
                .mapToDouble(FraisForfait::getMontant)
                .sum();
    }

    // 🔁 Convertir une entité en DTO
    private FraisForfaitDTO convertToDTO(FraisForfait fraisForfait) {
        FraisForfaitDTO dto = new FraisForfaitDTO();
        dto.setId(fraisForfait.getId());
        dto.setLibelle(fraisForfait.getLibelle());
        dto.setMontant(fraisForfait.getMontant());
        return dto;
    }

    // 🔁 Convertir un DTO en entité
    private FraisForfait convertToEntity(FraisForfaitDTO dto) {
        FraisForfait fraisForfait = new FraisForfait();
        fraisForfait.setId(dto.getId());
        fraisForfait.setLibelle(dto.getLibelle());
        fraisForfait.setMontant(dto.getMontant());
        return fraisForfait;
    }
}