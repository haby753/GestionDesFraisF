package com.example.demo.restcontrollers;

import com.example.demo.dto.LigneFraisHorsForfaitDTO;
import com.example.demo.service.LigneFraisHorsForfaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/lignefraishorsforfait")
public class LigneFraisHorsForfaitRestController {

    @Autowired
    private LigneFraisHorsForfaitService ligneFraisHorsForfaitService;

    @GetMapping("/all")
    public ResponseEntity<List<LigneFraisHorsForfaitDTO>> getAllLignesFraisHorsForfait() {
        List<LigneFraisHorsForfaitDTO> lignes = ligneFraisHorsForfaitService.getAllLignesFraisHorsForfait();
        return ResponseEntity.ok(lignes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneFraisHorsForfaitDTO> getLigneFraisHorsForfaitById(@PathVariable Long id) {
        LigneFraisHorsForfaitDTO ligne = ligneFraisHorsForfaitService.getLigneFraisHorsForfaitById(id);
        return ligne != null ? ResponseEntity.ok(ligne) : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<LigneFraisHorsForfaitDTO> saveLigneFraisHorsForfait(@RequestBody LigneFraisHorsForfaitDTO dto) {
        LigneFraisHorsForfaitDTO savedLigne = ligneFraisHorsForfaitService.saveLigneFraisHorsForfait(dto);
        return ResponseEntity.ok(savedLigne);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLigneFraisHorsForfait(@PathVariable Long id) {
        ligneFraisHorsForfaitService.deleteLigneFraisHorsForfait(id);
        return ResponseEntity.noContent().build();
    }
}