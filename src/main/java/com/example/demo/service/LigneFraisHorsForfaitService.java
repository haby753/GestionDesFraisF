package com.example.demo.service;
import com.example.demo.entity.FicheFrais;
import com.example.demo.dto.LigneFraisHorsForfaitDTO;
import com.example.demo.entity.LigneFraisHorsForfait;
import com.example.demo.repository.LigneFraisHorsForfaitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class LigneFraisHorsForfaitService {

    @Autowired
    private LigneFraisHorsForfaitRepository ligneFraisHorsForfaitRepository;

    public List<LigneFraisHorsForfaitDTO> getAllLignesFraisHorsForfait() {
        List<LigneFraisHorsForfait> lignes = ligneFraisHorsForfaitRepository.findAll();
        return lignes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Double getTotalMontantHorsForfaitPourDepartement91() {
        Double total = ligneFraisHorsForfaitRepository.getTotalMontantHorsForfaitPourDepartement91();
        return total != null ? total : 0.0;
    }
    
    
    public LigneFraisHorsForfaitDTO getLigneFraisHorsForfaitById(Long id) {
        Optional<LigneFraisHorsForfait> ligne = ligneFraisHorsForfaitRepository.findById(id);
        return ligne.map(this::convertToDTO).orElse(null);
    }

    public LigneFraisHorsForfaitDTO saveLigneFraisHorsForfait(LigneFraisHorsForfaitDTO dto) {
        LigneFraisHorsForfait ligne = convertToEntity(dto);
        LigneFraisHorsForfait savedLigne = ligneFraisHorsForfaitRepository.save(ligne);
        return convertToDTO(savedLigne);
    }

    public void deleteLigneFraisHorsForfait(Long id) {
        ligneFraisHorsForfaitRepository.deleteById(id);
    }

    private LigneFraisHorsForfaitDTO convertToDTO(LigneFraisHorsForfait ligne) {
        LigneFraisHorsForfaitDTO dto = new LigneFraisHorsForfaitDTO();
        dto.setId(ligne.getId());
        dto.setMontant(ligne.getMontant());
        dto.setDescription(ligne.getDescription());
      //  dto.setFicheFraisId(ligne.getFicheFrais() != null ? ligne.getFicheFrais().getId() : null);
        dto.setDate(ligne.getDate());
        return dto;
    }

    private LigneFraisHorsForfait convertToEntity(LigneFraisHorsForfaitDTO dto) {
        LigneFraisHorsForfait ligne = new LigneFraisHorsForfait();
        ligne.setId(dto.getId());
        ligne.setMontant(dto.getMontant());
        ligne.setDescription(dto.getDescription());
        if (dto.getFicheFraisId() != null) {
            FicheFrais ficheFrais = new FicheFrais();
           // ficheFrais.setId(dto.getFicheFraisId());
            ligne.setFicheFrais(ficheFrais);
        }
        ligne.setDate(dto.getDate());
        return ligne;
    }
}