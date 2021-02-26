package com.urbanisationsi.microservices_portefeuille.http.controleur;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.urbanisationsi.microservices_portefeuille.dao.PortefeuilleActionRepository;
import com.urbanisationsi.microservices_portefeuille.exceptions.PortefeuilleIntrouvableException;
import com.urbanisationsi.microservices_portefeuille.modele.PortefeuilleAction;

import io.swagger.annotations.Api;

@Api(description = "API pour les opérations CRUD pour les actions d'un portefeuille")
@CrossOrigin(origins = "*")
@RestController  
@RequestMapping(path="/portefeuilleaction")  
public class PortefeuilleActionControleur 
{
    @Autowired  
    private PortefeuilleActionRepository portefeuilleActionRepository;

    Logger log = LoggerFactory.getLogger(this.getClass()); 

    @PostMapping(path="/ajouterUneActionAuPortefeuille")
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

    @GetMapping(path="/numeroPortefeuille/{idPortefeuille}")
	public List<PortefeuilleAction> rechercherPortefeuilleActionParIdPortefeuille(@PathVariable  Integer idPortefeuille) 
    {
		List<PortefeuilleAction> listePortefeuilleAction = (List<PortefeuilleAction>) portefeuilleActionRepository.rechercherPortefeuilleActionParIdPortefeuille(idPortefeuille);
		if(listePortefeuilleAction.isEmpty()) 
			throw new PortefeuilleIntrouvableException("Aucun portefeuille n'a été enregistré avec cet Id: "+idPortefeuille);
		else
			return listePortefeuilleAction;
	}

    @GetMapping(path="/action/{codeAction}")
	public List<PortefeuilleAction> rechercherPortefeuilleActionParCodeAction(@PathVariable  String codeAction) 
    {
		List<PortefeuilleAction> listePortefeuilleAction = (List<PortefeuilleAction>) portefeuilleActionRepository.rechercherAction(codeAction);
		if(listePortefeuilleAction.isEmpty()) 
			throw new PortefeuilleIntrouvableException("Pas de code Action: "+codeAction);
		else
			return listePortefeuilleAction;
	}
    
    @DeleteMapping (path="/portefeuille/action/{idPortefeuille}/{codeAction}")     
    public void supprimerPortefeuilleActionAvecId(@PathVariable Integer idPortefeuille, @PathVariable String codeAction) 
    {
     portefeuilleActionRepository.deletecodeActionInIdPortefeuille(idPortefeuille, codeAction);        
    }

    @DeleteMapping (path="/portefeuille/{idPortefeuille}")     
    public void supprimerPortefeuilleActionAvecIdPortefeuille(@PathVariable Integer idPortefeuille) 
    {
     portefeuilleActionRepository.deleteByIdPortefeuille(idPortefeuille);        
    }
    
    @PutMapping (path="/modifierPortefeuilleAction")    
    public void modifierPortefeuilleAction(@RequestBody PortefeuilleAction portefeuilleAction) 
    {
      portefeuilleActionRepository.save(portefeuilleAction);
    }    
}