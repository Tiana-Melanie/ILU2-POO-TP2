package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
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
	}
	
	@Test
	public void testControlPrendreEtal() {
		ControlPrendreEtal prendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		assertNotNull(prendreEtal, "Erreur un constructeur n'est jamais null.");
	}
	
	@Test
	public void testresteEtals() {
		ControlPrendreEtal etal = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		assertEquals(true, etal.resteEtals());
	}
	
	@Test 
	public void testprendreEtal() {
		ControlPrendreEtal etal =  new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		String produit = "fleur";
		int nbr = 8;
		assertEquals(true, etal.resteEtals());
		assertNotNull(etal.prendreEtal(obelix.getNom(), produit, nbr));
	}
	
	@Test
	public void testVerifierIdentite() {
		ControlPrendreEtal etal =  new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		String nom = obelix.getNom();
		etal.verifierIdentite(nom);
		assertNotNull(nom);
		assertEquals(true, etal.verifierIdentite(nom));
	}
	
	@Test
	public void testVerifierIdentiteInconnue() { //il n'est pas dans le village
		ControlPrendreEtal etal =  new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		Gaulois asterix = new Gaulois("Astérix", 3);
		assertEquals(false, etal.verifierIdentite(asterix.getNom()));
	}

}
