package com.robica.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Article implements Serializable {
    public Article(String reference, Double qtestock, Double seuil, String libelle, String observation, String rayon,
			Categorie categorie) {
		super();
		this.reference = reference;
		this.qtestock = qtestock;
		this.seuil = seuil;
		this.libelle = libelle;
		this.observation = observation;
		this.rayon = rayon;
		this.categorie = categorie;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
    @Id
    private String reference;
    private Double qtestock;
    private Double seuil;
    private String libelle;
    private String observation;
    private String rayon;
  
    @OneToOne
    private Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public Double getSeuil() {
        return seuil;
    }

    public void setSeuil(Double seuil) {
        this.seuil = seuil;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
    public Double getQtestock() {
        return qtestock;
    }

    public void setQtestock(Double qtestock) {
        this.qtestock = qtestock;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

   
    

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.reference);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (!Objects.equals(this.reference, other.reference)) {
            return false;
        }
        return true;
    }

    
    
   
}
