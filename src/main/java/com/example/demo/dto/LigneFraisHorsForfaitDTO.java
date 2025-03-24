package com.example.demo.dto;

import java.time.LocalDate;



public class LigneFraisHorsForfaitDTO {

    private Long id;
    private Double montant;
    private String description;
   

	private FicheFraisDTO ficheFraisId; // Id de la fiche de frais associée
    public FicheFraisDTO getFicheFraisId() {
		return ficheFraisId;
	}

	public void setFicheFraisId(FicheFraisDTO ficheFraisId) {
		this.ficheFraisId = ficheFraisId;
	}

	private LocalDate date;
    public VisiteurDTO getIdvisiteur() {
		return idvisiteur;
	}

	public void setIdvisiteur(VisiteurDTO idvisiteur) {
		this.idvisiteur = idvisiteur;
	}

	private VisiteurDTO idvisiteur;
    
  
	
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}