package com.example.demo.dto;

public class FraisForfaitDTO {
    private Long id;
    private String libelle;
    private Double montant;
    @Override
	public String toString() {
		return "FraisForfaitDTO [id=" + id + ", libelle=" + libelle + ", montant=" + montant + "]";
	}
	

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Double getMontant() {
        return montant;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }
}