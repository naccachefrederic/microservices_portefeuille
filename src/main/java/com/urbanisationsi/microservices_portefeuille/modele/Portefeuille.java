package com.urbanisationsi.microservices_portefeuille.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public abstract class Portefeuille 
{
	@Id    
    @GeneratedValue(strategy=GenerationType.AUTO)   
    protected Integer id;

	@Length(min=3, max=30, message = "Le nombre de caractères du nom du portefeuille doit être compris entre 3 et 30 au sens large.") 	
	protected String nom;
	protected Long idPersonne;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
}
