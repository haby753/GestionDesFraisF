package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class LigneFraisHorsForfait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double montant;

    @Column(nullable = false)
    
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fiche_frais_id", nullable = false)
    private FicheFrais ficheFrais;
    @ManyToOne(fetch = FetchType.LAZY)
	private Visiteur visiteur;
    
    private LocalDate date;
    
      public Visiteur getIdvisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}



    // Getters et Setters
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

    public FicheFrais getFicheFrais() {
        return ficheFrais;
    }

    public void setFicheFrais(FicheFrais ficheFrais) {
        this.ficheFrais = ficheFrais;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}