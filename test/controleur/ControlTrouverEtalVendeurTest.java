package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

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
	void testControlTrouverVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}
	
	@Test 
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur control = new ControlTrouverEtalVendeur(village);
		Etal etal = control.trouverEtalVendeur(obelix.getNom());
		assertNotNull(etal, "Erreur l'étal ne devrait pas être nul.");
		assertEquals(obelix, etal.getVendeur());
	}

}
