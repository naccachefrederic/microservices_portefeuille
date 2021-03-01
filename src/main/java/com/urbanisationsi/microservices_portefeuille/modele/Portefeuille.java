package com.urbanisationsi.microservices_portefeuille.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Portefeuille 
{
	@Id    
    @GeneratedValue(strategy=GenerationType.AUTO)   
	protected Integer 	id; 
	protected String 	username;
	protected double 	capital;
	
	public Integer getId() {
		return id;
	}
	public void setIdPortefeuille(Integer idPortefeuille) {
		this.id = idPortefeuille;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
}
