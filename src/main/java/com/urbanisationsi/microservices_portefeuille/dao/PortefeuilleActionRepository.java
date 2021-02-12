package com.urbanisationsi.microservices_portefeuille.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.urbanisationsi.microservices_portefeuille.modele.Portefeuille;
import com.urbanisationsi.microservices_portefeuille.modele.PortefeuilleAction;

public interface PortefeuilleActionRepository extends CrudRepository<PortefeuilleAction, Integer> 
{
	public List<PortefeuilleAction> findAll();	
	
	@Query("delete from PortefeuilleAction pa where pa.idportefeuille = :idp")
	public void deleteByIdPortefeuille(@Param("idp") Integer idp);

	@Query("from PortefeuilleAction pa where pa.idportefeuille = :idp")
	public List<PortefeuilleAction> rechercherPortefeuilleActionParIdPortefeuille(@Param("idp") Integer idp);
}
