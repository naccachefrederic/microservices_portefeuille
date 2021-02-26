package com.urbanisationsi.microservices_portefeuille.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.urbanisationsi.microservices_portefeuille.modele.PortefeuilleAction;

public interface PortefeuilleActionRepository extends CrudRepository<PortefeuilleAction, Integer> 
{
	public List<PortefeuilleAction> findAll();	

	@Transactional
	@Modifying
	@Query("delete from PortefeuilleAction pa where pa.idportefeuille = :idp and pa.codeaction = :ca")
	public void deletecodeActionInIdPortefeuille(@Param("idp") Integer idp, @Param("ca") String ca);
	
	@Transactional
	@Modifying
	@Query("delete from PortefeuilleAction pa where pa.idportefeuille = :idp")
	public void deleteByIdPortefeuille(@Param("idp") Integer idp);

	@Query("from PortefeuilleAction pa where pa.idportefeuille = :idp")
	public List<PortefeuilleAction> rechercherPortefeuilleActionParIdPortefeuille(@Param("idp") Integer idp);

	@Query("from PortefeuilleAction pa where pa.codeaction = :ca")
	public List<PortefeuilleAction> rechercherAction(@Param("ca") String ca);
}
