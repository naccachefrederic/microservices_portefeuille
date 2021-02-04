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

import com.urbanisationsi.microservices_portefeuille.dao.PortefeuilleRepository;
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

    @PostMapping(path="/ajouterPortefeuille")
    public ResponseEntity<Void> creerPortefeuille(@Valid @RequestBody Portefeuille portefeuille) 
    {
    		log.info("Appel de creerPortefeuille");
        	Portefeuille portefeuilleAjoute = portefeuilleRepository.save(portefeuille);

             if (portefeuilleAjoute == null)
                        return ResponseEntity.noContent().build();

                URI uri = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(portefeuilleAjoute.getId())
                        .toUri();

                return ResponseEntity.created(uri).build(); 
    }

    @GetMapping(path="/listerLesPortefeuilles")  
    public @ResponseBody Iterable<Portefeuille>  getAllPortefeuille() 
    {
		Iterable<Portefeuille> listePortefeuille = portefeuilleRepository.findAll();
		return listePortefeuille;
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

    @DeleteMapping (path="/Portefeuille/{id}")     
    public void supprimerPortefeuiller(@PathVariable Integer id) 
    {
     portefeuilleRepository.deleteById(id);        
    }

    @PutMapping (path="/modifierPortefeuille")    
    public void modifierPortefeuille(@RequestBody Portefeuille portefeuille) 
    {
      portefeuilleRepository.save(portefeuille);
    }    
}