package com.example.demo.service;

import com.example.demo.dto.FraisForfaitDTO;
import com.example.demo.entity.FraisForfait;
import com.example.demo.repository.FraisForfaitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FraisForfaitService {

    @Autowired
    private FraisForfaitRepository fraisForfaitRepository;

    public List<FraisForfaitDTO> getAllFraisForfait() {
        List<FraisForfait> fraisForfaits = fraisForfaitRepository.findAll();
        return fraisForfaits.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public FraisForfaitDTO getFraisForfaitById(Long id) {
        Optional<FraisForfait> fraisForfait = fraisForfaitRepository.findById(id);
        return fraisForfait.map(this::convertToDTO).orElse(null);
    }

    public FraisForfaitDTO saveFraisForfait(FraisForfaitDTO dto) {
        FraisForfait fraisForfait = convertToEntity(dto);
        FraisForfait savedFraisForfait = fraisForfaitRepository.save(fraisForfait);
        return convertToDTO(savedFraisForfait);
    }

    public void deleteFraisForfait(Long id) {
        fraisForfaitRepository.deleteById(id);
    }

    private FraisForfaitDTO convertToDTO(FraisForfait fraisForfait) {
        FraisForfaitDTO dto = new FraisForfaitDTO();
        dto.setId(fraisForfait.getId());
        dto.setLibelle(fraisForfait.getLibelle());
        dto.setMontant(fraisForfait.getMontant());
        return dto;
    }

    private FraisForfait convertToEntity(FraisForfaitDTO dto) {
        FraisForfait fraisForfait = new FraisForfait();
        fraisForfait.setId(dto.getId());
        fraisForfait.setLibelle(dto.getLibelle());
        fraisForfait.setMontant(dto.getMontant());
        return fraisForfait;
    }
}