package com.urbanisationsi.microservices_portefeuille.http.controleur;

import java.net.URI;
import java.util.List;

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

import com.urbanisationsi.microservices_portefeuille.dao.PortefeuilleRepository;
import com.urbanisationsi.microservices_portefeuille.exceptions.PortefeuilleIntrouvableException;
import com.urbanisationsi.microservices_portefeuille.modele.Portefeuille;

import io.swagger.annotations.Api;

@Api(description = "API pour les opérations CRUD pour les portefeuilles")
@RestController  
@RequestMapping(path="/portefeuille")  
public class PortefeuilleControleur 
{ 
    @Autowired  
    private PortefeuilleRepository portefeuilleRepository;

    Logger log = LoggerFactory.getLogger(this.getClass()); 

    @PostMapping(path="/ajouterUnPortefeuille")
    public ResponseEntity<Void> creerPortefeuille(@Valid @RequestBody Portefeuille portefeuille) 
    {
    		log.info("Appel de creerPortefeuille");
        	Portefeuille portefeuilleAjoute = portefeuilleRepository.save(portefeuille);

             if (portefeuilleAjoute == null)
                        return ResponseEntity.noContent().build();

                URI uri = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(portefeuilleAjoute.getIdPortefeuille())
                        .toUri();

                return ResponseEntity.created(uri).build(); 
    }

    @GetMapping(path="/listerTousLesPortefeuilles")  
    public @ResponseBody Iterable<Portefeuille>  getAllPortefeuille() 
    {
		Iterable<Portefeuille> listePortefeuille = portefeuilleRepository.findAll();
		return listePortefeuille;
    }
    
    
    @GetMapping(path="/rechercheParUserEmail/{useremail}")
	public List<Portefeuille> rechercherPortefeuilleUserEmail(@PathVariable  String useremail) 
    {
		List<Portefeuille> listePortefeuille = (List<Portefeuille>) portefeuilleRepository.rechercherPortefeuilleParUserEmail(useremail);
		if(listePortefeuille.isEmpty()) 
			throw new PortefeuilleIntrouvableException("Aucun portefeuille n'a été enregistré avec cet email.");
		else
			return listePortefeuille;
	}
	

    @DeleteMapping (path="/supprimerAvecId/{id}")     
    public void supprimerPortefeuilleAvecId(@PathVariable Integer id) 
    {
     portefeuilleRepository.deleteById(id);        
    }

    @DeleteMapping (path="/supprimerAvecEmail/{email}")     
    public void supprimerPortefeuilleAvecEmail(@PathVariable String email) 
    {
     portefeuilleRepository.deleteByUseremail(email);        
    }

    @PutMapping (path="/modifierUnPortefeuille")    
    public void modifierPortefeuille(@RequestBody Portefeuille portefeuille) 
    {
      portefeuilleRepository.save(portefeuille);
    }    
}