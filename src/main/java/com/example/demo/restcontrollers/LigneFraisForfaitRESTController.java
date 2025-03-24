package com.example.demo.restcontrollers;


import com.example.demo.service.LigneFraisForfaitService;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.dto.LigneFraisForfaitDTO;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lignefraisforfait")
@CrossOrigin(origins = "http://localhost:4200")
public class LigneFraisForfaitRESTController {

    @Autowired
    private LigneFraisForfaitService ligneFraisForfaitService;

    @GetMapping("/all")
    public List<LigneFraisForfaitDTO> getAllLignesFraisForfait() {
        return ligneFraisForfaitService.getAllLignesFraisForfait();
    }

    @GetMapping("/{id}")
    public LigneFraisForfaitDTO getLigneFraisForfaitById(@PathVariable("id") Long id) {
        return ligneFraisForfaitService.getLigneFraisForfaitById(id);
    }

    @PostMapping("/save")
    public LigneFraisForfaitDTO saveLigneFraisForfait(@RequestBody LigneFraisForfaitDTO dto) {
        return ligneFraisForfaitService.saveLigneFraisForfait(dto);
    }

    @PutMapping("/update")
    public LigneFraisForfaitDTO updateLigneFraisForfait(@RequestBody LigneFraisForfaitDTO dto) {
        return ligneFraisForfaitService.saveLigneFraisForfait(dto); // Save fonctionne comme update ici
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLigneFraisForfait(@PathVariable("id") Long id) {
        ligneFraisForfaitService.deleteLigneFraisForfait(id);
    }
}
