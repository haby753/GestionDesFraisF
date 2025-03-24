package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

public class VisiteurDTO {
	
	private Long id;
	private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String cp;
    private LocalDate dateEmbauche;
    private String login;
    private String mdp;
   // private List<FicheFraisDTO> fichesFrais;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	//public List<FicheFraisDTO> getFichesFrais() {
	//	return fichesFrais;
	//}
	//public void setFichesFrais(List<FicheFraisDTO> fichesFrais) {
	//	this.fichesFrais = fichesFrais;
	//}

    @Override
	public String toString() {
		return "VisiteurDTO [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", ville="
				+ ville + ", cp=" + cp + ", dateEmbauche=" + dateEmbauche + ", login=" + login + ", mdp=" + mdp
				 + "]";
	}
 // Mois associés aux fiches frais

    // Getters et setters
}