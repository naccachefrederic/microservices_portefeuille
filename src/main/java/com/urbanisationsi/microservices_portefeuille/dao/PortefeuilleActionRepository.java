package com.urbanisationsi.microservices_portefeuille.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.microservices_portefeuille.modele.Portefeuille;
import com.urbanisationsi.microservices_portefeuille.modele.PortefeuilleAction;

public interface PortefeuilleActionRepository extends CrudRepository<PortefeuilleAction, Integer> 
{
	public List<PortefeuilleAction> findAll();	
	
	/*
	@Query("from Assure a where a.nom = :nm and a.numeroAssure = :na ")
	public List<Assure> rechercherAssureNomNumeroAssure(@Param("nm") String nom, @Param("na") Long numeroAssure);
	*/
}
