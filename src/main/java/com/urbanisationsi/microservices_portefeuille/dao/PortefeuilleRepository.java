package com.urbanisationsi.microservices_portefeuille.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.urbanisationsi.microservices_portefeuille.modele.Portefeuille;

public interface PortefeuilleRepository extends CrudRepository<Portefeuille, Integer> 
{
	public List<Portefeuille> findAll();	
	
	@Query("from Portefeuille p where p.username = :un")
	public List<Portefeuille> rechercherPortefeuilleParUserName(@Param("un") String username);
	
	@Transactional
	@Modifying
	@Query("delete from Portefeuille p where p.username = :un")
	public void deleteByUsername(@Param("un") String username);
}
