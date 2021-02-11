package com.urbanisationsi.microservices_portefeuille.http.controleur;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.urbanisationsi.microservices_portefeuille.dao.PortefeuilleActionRepository;
import com.urbanisationsi.microservices_portefeuille.modele.Portefeuille;
import com.urbanisationsi.microservices_portefeuille.modele.PortefeuilleAction;

import io.swagger.annotations.Api;

@Api(description = "API pour les opérations CRUD pour les actions d'un portefeuille")
@RestController  
@RequestMapping(path="/portefeuilleaction")  
public class PortefeuilleActionControleur 
{
    @Autowired  
    private PortefeuilleActionRepository portefeuilleActionRepository;

    Logger log = LoggerFactory.getLogger(this.getClass()); 

    @PostMapping(path="/ajouterActionAuPortefeuille")
    public ResponseEntity<Void> creerPortefeuilleAction(@Valid @RequestBody PortefeuilleAction portefeuilleAction) 
    {
    		log.info("Appel de creerPortefeuilleAction");
        	PortefeuilleAction portefeuilleActionAjoute = portefeuilleActionRepository.save(portefeuilleAction);

             if (portefeuilleActionAjoute == null)
                        return ResponseEntity.noContent().build();

                URI uri = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(portefeuilleActionAjoute.getIdPortefeuilleAction())
                        .toUri();

                return ResponseEntity.created(uri).build(); 
    }

    @GetMapping(path="/listerLesActionsDansPortefeuilles")  
    public @ResponseBody Iterable<PortefeuilleAction>  getAllPortefeuilleAction() 
    {
		Iterable<PortefeuilleAction> listePortefeuilleAction = portefeuilleActionRepository.findAll();
		return listePortefeuilleAction;
    }
    
    /*
    @GetMapping(path="/Portefeuille/numeroPortefeuille/{numeroPortefeuille}")
	public List<Portefeuille> rechercherPortefeuilleNumeroPortefeuille(@PathVariable  Long numeroPortefeuille) 
    {
		List<Portefeuille> listePortefeuille = (List<Portefeuille>) portefeuilleRepository.rechercherPortefeuilleParNumeroPortefeuille(numeroPortefeuille);
		if(listePortefeuille.isEmpty()) 
			throw new PortefeuilleIntrouvableException("Aucun portefeuille n'a été enregistré.");
		else
			return listePortefeuille;
	}
	*/

    @DeleteMapping (path="/PortefeuilleAction/{id}")     
    public void supprimerPortefeuilleAction(@PathVariable Integer id) 
    {
     portefeuilleActionRepository.deleteById(id);        
    }

    @PutMapping (path="/modifierPortefeuilleAction")    
    public void modifierPortefeuilleAction(@RequestBody PortefeuilleAction portefeuilleAction) 
    {
      portefeuilleActionRepository.save(portefeuilleAction);
    }    
}