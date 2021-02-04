package com.urbanisationsi.microservices_portefeuille.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.microservices_portefeuille.modele.Portefeuille;

public interface PortefeuilleRepository extends CrudRepository<Portefeuille, Integer> 
{
	public List<Portefeuille> findAll();	
	
	/*
	@Query("from Assure a where a.nom = :nm and a.numeroAssure = :na ")
	public List<Assure> rechercherAssureNomNumeroAssure(@Param("nm") String nom, @Param("na") Long numeroAssure);
	*/
}
