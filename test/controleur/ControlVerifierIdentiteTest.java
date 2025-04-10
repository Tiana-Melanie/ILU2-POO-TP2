package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois obelix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisaton ...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "fleurs", 5);
	}
	@Test 
	public void testControlVerifierIdentite() {
		ControlVerifierIdentite verifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(verifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	public void testVerifierIdentite() {
		ControlVerifierIdentite verifier = new ControlVerifierIdentite(village);
		String nom = obelix.getNom();
		verifier.verifierIdentite(nom);
		assertNotNull(nom);
		assertEquals(true, verifier.verifierIdentite(nom));
	}
	
	@Test
	public void testVerifierIdentiteInconnue() { //il n'est pas dans le village
		ControlVerifierIdentite verifier = new ControlVerifierIdentite(village);
		Gaulois asterix = new Gaulois("Astérix", 10);
		assertEquals(false, verifier.verifierIdentite(asterix.getNom()));
	}

}
