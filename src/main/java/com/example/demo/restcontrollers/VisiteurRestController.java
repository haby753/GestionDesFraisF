package com.example.demo.restcontrollers;

import com.example.demo.dto.VisiteurDTO;
import com.example.demo.entity.LoginRequest;
import com.example.demo.entity.Visiteur;
import com.example.demo.service.VisiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
	    origins = "http://localhost:4200",
	    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
	)

@RequestMapping("/api/visiteur")

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
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Visiteur visiteur = visiteurService.getVisiteurByLogin(loginRequest.getUsername());
        if (visiteur != null && visiteur.getMdp().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(visiteur); // Retourner l'objet Visiteur
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe incorrect");
        }
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