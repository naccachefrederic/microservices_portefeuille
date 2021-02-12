package com.urbanisationsi.microservices_portefeuille;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.urbanisationsi.microservices_portefeuille.exceptions.PortefeuilleIntrouvableException;
import com.urbanisationsi.microservices_portefeuille.http.controleur.PortefeuilleControleur;
import com.urbanisationsi.microservices_portefeuille.modele.Portefeuille;

@SpringBootTest
class MicroservicePortefeuilleApplicationTests {

	@Autowired
	private PortefeuilleControleur pc;
	
	@Test
	void contextLoads() {
		
		String useremail = "naccachefrederic@gmail.com";
		List<Portefeuille> result = pc.rechercherPortefeuilleUserEmail(useremail);
		assertThat(!result.isEmpty());

		final String useremail1 = "error@gmail.com";
		assertThatThrownBy(() -> pc.rechercherPortefeuilleUserEmail(useremail1)).isInstanceOf(PortefeuilleIntrouvableException.class);
		
	}
}
