package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
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
	public void testControlAfficherMarche(){
		ControlAfficherMarche marche = new ControlAfficherMarche(village);
		assertNotNull(marche, "Erreur un constructeur n'est pas null");
	}

	@Test
	public void testdonnerInfosMarcheVide() {
		ControlAfficherMarche marche = new ControlAfficherMarche(village);
		String[] donnees = marche.donnerInfosMarche();
		assertEquals(0, donnees.length);
	}
	
	@Test
	public void testdonnerInfosMarche() {
		ControlAfficherMarche marche = new ControlAfficherMarche(village);
		village.installerVendeur(obelix, "fleurs", 5);
		String[] donnees = marche.donnerInfosMarche();
		assertEquals(3,donnees.length);
		assertEquals(obelix.getNom(), donnees[0]);
		assertEquals("5", donnees[1]);
		assertEquals("fleurs", donnees[2]);
	}

}
