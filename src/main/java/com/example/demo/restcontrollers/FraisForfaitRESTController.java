package com.example.demo.restcontrollers;

import com.example.demo.dto.FraisForfaitDTO;
import com.example.demo.service.FraisForfaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraisforfait")
@CrossOrigin(origins = "http://localhost:4200")

public class FraisForfaitRESTController {

    @Autowired
    private FraisForfaitService fraisForfaitService;

    @GetMapping("/all")
    public List<FraisForfaitDTO> getAllFraisForfait() {
        return fraisForfaitService.getAllFraisForfait();
    }

    @GetMapping("/{id}")
    public FraisForfaitDTO getFraisForfaitById(@PathVariable("id") Long id) {
        return fraisForfaitService.getFraisForfaitById(id);
    }

    @PostMapping("/save")
    public FraisForfaitDTO saveFraisForfait(@RequestBody FraisForfaitDTO dto) {
        return fraisForfaitService.saveFraisForfait(dto);
    }

    @PutMapping("/update")
    public FraisForfaitDTO updateFraisForfait(@RequestBody FraisForfaitDTO dto) {
        return fraisForfaitService.saveFraisForfait(dto); // Save fonctionne comme update ici
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFraisForfait(@PathVariable("id") Long id) {
        fraisForfaitService.deleteFraisForfait(id);
    }
}