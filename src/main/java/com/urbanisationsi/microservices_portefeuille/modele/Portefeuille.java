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
	protected Integer 	idPortefeuille; 
	protected String 	useremail;
	protected double 	capital;
	
	public Integer getIdPortefeuille() {
		return idPortefeuille;
	}
	public void setIdPortefeuille(Integer idPortefeuille) {
		this.idPortefeuille = idPortefeuille;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
}
