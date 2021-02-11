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
	protected Integer 	idPortefeuilleAction; 
	protected Integer 	idPortefeuille;
	protected String 	codeaction;
	protected Double 	valeuroriginaleaction;
	protected Date 		dateachataction;
	protected Integer	quantiteaction;
	
	public Integer getIdPortefeuilleAction() {
		return idPortefeuilleAction;
	}
	public void setIdPortefeuilleAction(Integer idPortefeuilleAction) {
		this.idPortefeuilleAction = idPortefeuilleAction;
	}
	public Integer getIdPortefeuille() {
		return idPortefeuille;
	}
	public void setIdPortefeuille(Integer idPortefeuille) {
		this.idPortefeuille = idPortefeuille;
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
