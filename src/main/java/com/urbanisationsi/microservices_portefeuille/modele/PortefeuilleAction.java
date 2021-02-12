package com.urbanisationsi.microservices_portefeuille.modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PortefeuilleAction {
	@Id    
    @GeneratedValue(strategy=GenerationType.AUTO)   
	protected Integer 	id; 
	protected Integer 	idportefeuille;
	protected String 	codeaction;
	protected Double 	valeuroriginaleaction;
	protected Date 		dateachataction;
	protected Integer	quantiteaction;
	
	public Integer getIdPortefeuilleAction() {
		return id;
	}
	public void setIdPortefeuilleAction(Integer id) {
		this.id = id;
	}
	public Integer getIdPortefeuille() {
		return idportefeuille;
	}
	public void setIdPortefeuille(Integer idportefeuille) {
		this.idportefeuille = idportefeuille;
	}
	public String getCodeaction() {
		return codeaction;
	}
	public void setCodeaction(String codeaction) {
		this.codeaction = codeaction;
	}
	public Double getValeuroriginaleaction() {
		return valeuroriginaleaction;
	}
	public void setValeuroriginaleaction(Double valeuroriginaleaction) {
		this.valeuroriginaleaction = valeuroriginaleaction;
	}
	public Date getDateachataction() {
		return dateachataction;
	}
	public void setDateachataction(Date dateachataction) {
		this.dateachataction = dateachataction;
	}
	public Integer getQuantiteaction() {
		return quantiteaction;
	}
	public void setQuantiteaction(Integer quantiteaction) {
		this.quantiteaction = quantiteaction;
	}
}
