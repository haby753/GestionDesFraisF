package com.example.demo.dto;

import java.time.LocalDate;



public class LigneFraisHorsForfaitDTO {

	private Long id;
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
	public Long getFicheFraisId() {
		return ficheFraisId;
	}
	public void setFicheFraisId(Long ficheFraisId) {
		this.ficheFraisId = ficheFraisId;
	}
	public Long getVisiteurId() {
		return visiteurId;
	}
	public void setVisiteurId(Long visiteurId) {
		this.visiteurId = visiteurId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	private Double montant;
    private String description;
    private Long ficheFraisId;
    private Long visiteurId;
    private LocalDate date;
}