package com.example.demo.service;

import com.example.demo.dto.EtatDTO;
import com.example.demo.entity.Etat;
import com.example.demo.repository.EtatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtatService {

    @Autowired
    private EtatRepository etatRepository;

    public List<EtatDTO> getAllEtat() {
        return etatRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EtatDTO getEtatById(Long id) {
        Optional<Etat> etat = etatRepository.findById(id);
        return etat.map(this::convertToDTO).orElse(null);
    }

    public EtatDTO saveEtat(EtatDTO etatDTO) {
        Etat etat = convertToEntity(etatDTO);
        Etat savedEtat = etatRepository.save(etat);
        return convertToDTO(savedEtat);
    }

    public void deleteEtat(Long id) {
        etatRepository.deleteById(id);
    }

    private EtatDTO convertToDTO(Etat etat) {
        EtatDTO dto = new EtatDTO();
        dto.setId(etat.getId());
        dto.setLibelle(etat.getLibelle());
        return dto;
    }

    private Etat convertToEntity(EtatDTO dto) {
        Etat etat = new Etat();
        etat.setId(dto.getId());
        etat.setLibelle(dto.getLibelle());
        return etat;
    }
}