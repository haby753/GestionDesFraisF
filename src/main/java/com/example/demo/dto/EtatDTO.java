package com.example.demo.dto;

public class EtatDTO {
    @Override
	public String toString() {
		return "EtatDTO [id=" + id + ", libelle=" + libelle + "]";
	}
	private Long id;
    private String libelle;

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
}