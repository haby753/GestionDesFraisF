package com.example.demo.restcontrollers;

import com.example.demo.dto.EtatDTO;
import com.example.demo.service.EtatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etat")
@CrossOrigin(origins = "http://localhost:4200")

public class EtatRESTController {

    @Autowired
    private EtatService etatService;

    @GetMapping("/all")
    public List<EtatDTO> getAllEtat() {
        return etatService.getAllEtat();
    }

    @GetMapping("/{id}")
    public EtatDTO getEtatById(@PathVariable("id") Long id) {
        return etatService.getEtatById(id);
    }

    @PostMapping("/save")
    public EtatDTO saveEtat(@RequestBody EtatDTO etatDTO) {
        return etatService.saveEtat(etatDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtat(@PathVariable("id") Long id) {
        etatService.deleteEtat(id);
    }
}