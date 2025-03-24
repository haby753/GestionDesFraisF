package com.example.demo.restcontrollers;


import com.example.demo.service.FicheFraisService;
import com.example.demo.dto.FicheFraisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/fichefrais")
public class FicheFraisRESTController {
    @Autowired
    private FicheFraisService fichefraisService;

    @GetMapping("/all")
    public List<FicheFraisDTO> getAllFicheFrais() {
        return fichefraisService.getAllFicheFrais();
    }

    // Récupérer une fiche de frais par son ID
    @GetMapping("/{id}")
    public FicheFraisDTO getFicheFraisById(@PathVariable("id") Long id) {
        return fichefraisService.getFicheFraisById(id);
    }

    @PostMapping("/save")
    public FicheFraisDTO saveFicheFrais(@RequestBody FicheFraisDTO dto) {
        return fichefraisService.saveFicheFrais(dto);
    }
    

    // Mettre à jour une fiche de frais existante
    @PutMapping("/update/{id}")
    public FicheFraisDTO updateFicheFrais(@PathVariable("id") Long id, @RequestBody FicheFraisDTO ficheFraisDTO) {
        ficheFraisDTO.setId(id);  // Assurez-vous que l'ID est correctement mis à jour
        return fichefraisService.updateFicheFrais(ficheFraisDTO);
    }

    // Supprimer une fiche de frais par son ID
    @DeleteMapping("/delete/{id}")
    public void deleteFicheFrais(@PathVariable("id") Long id) {
        fichefraisService.deleteFicheFrais(id);  
    }
}