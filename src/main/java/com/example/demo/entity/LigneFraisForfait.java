package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneFraisForfait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public FicheFrais getFicheFrais() {
		return ficheFrais;
	}

	public void setFicheFrais(FicheFrais ficheFrais) {
		this.ficheFrais = ficheFrais;
	}

	public FraisForfait getFraisForfait() {
		return fraisForfait;
	}

	public void setFraisForfait(FraisForfait fraisForfait) {
		this.fraisForfait = fraisForfait;
	}

	private int quantite;

    @ManyToOne
    @JoinColumn(name = "fiche_frais_id", nullable = false)
    private FicheFrais ficheFrais;

    @ManyToOne
    @JoinColumn(name = "frais_forfait_id", nullable = false)
    private FraisForfait fraisForfait;

    // Getters et Setters
}