package com.example.demo.entity;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class FraisForfait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private int version;


    public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public List<LigneFraisForfait> getLigneFraisForfaits() {
		return ligneFraisForfaits;
	}

	public void setLigneFraisForfaits(List<LigneFraisForfait> ligneFraisForfaits) {
		this.ligneFraisForfaits = ligneFraisForfaits;
	}

	private String libelle;
    private double montant;

    @OneToMany(mappedBy = "fraisForfait", cascade = CascadeType.ALL)
    private List<LigneFraisForfait> ligneFraisForfaits = new ArrayList<>();

    
}