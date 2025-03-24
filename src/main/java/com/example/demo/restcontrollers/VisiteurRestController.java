package com.example.demo.restcontrollers;

import com.example.demo.dto.VisiteurDTO;

import com.example.demo.service.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/visiteur")
@CrossOrigin(origins = "http://localhost:4200")
public class VisiteurRestController {
	
    @Autowired
    private VisiteurService visiteurService;

    @GetMapping("/all")
    public List<VisiteurDTO> getAllVisiteurs() {
        return visiteurService.getAllVisiteurs();
    }

    @GetMapping("/{id}")
    public VisiteurDTO getVisiteurById(@PathVariable("id") Long id) {
        return visiteurService.getVisiteurById(id);
    }

    @PostMapping("/save")
    public VisiteurDTO saveVisiteur(@RequestBody VisiteurDTO dto) {
        return visiteurService.saveVisiteur(dto);
    }

    @PutMapping("/update")
    public VisiteurDTO updateVisiteur(@RequestBody VisiteurDTO dto) {
        return visiteurService.saveVisiteur(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVisiteur(@PathVariable("id") Long id) {
        visiteurService.deleteVisiteur(id);
    }
}