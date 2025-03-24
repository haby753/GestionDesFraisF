package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.Etat;
import com.example.demo.entity.Visiteur;



public class FicheFraisDTO {
    
	private Long id;
	private String mois;
    private Integer nbJustificatifs;
    private Double montantValide;
    private LocalDate dateModif;
	private VisiteurDTO visiteur_id;
	private EtatDTO etat_id;
	public VisiteurDTO getVisiteur_id() {
		return visiteur_id;
	}
	public void setVisiteur_id(VisiteurDTO visiteur_id) {
		this.visiteur_id = visiteur_id;
	}
	public EtatDTO getEtat_id() {
		return etat_id;
	}
	public void setEtat_id(EtatDTO etat_id) {
		this.etat_id = etat_id;
	}

    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public Integer getNbJustificatifs() {
		return nbJustificatifs;
	}
	public void setNbJustificatifs(Integer nbJustificatifs) {
		this.nbJustificatifs = nbJustificatifs;
	}
	public Double getMontantValide() {
		return montantValide;
	}
	public void setMontantValide(Double montantValide) {
		this.montantValide = montantValide;
	}
	public LocalDate getDateModif() {
		return dateModif;
	}
	public void setDateModif(LocalDate dateModif) {
		this.dateModif = dateModif;
	}
	

   
	
	

}
