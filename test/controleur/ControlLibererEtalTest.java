package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	
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
	public void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		assertNotNull(controlLibererEtal, "constructeur ne renvoie pas null. ");
	}
	
	@Test 
	public void testisVendeur() {
		ControlLibererEtal control = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		assertEquals(true, control.isVendeur(obelix.getNom()));
	}
	

	
	@Test
	public void testlibererEtal() {
		ControlLibererEtal control = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		assertEquals(true,control.isVendeur(obelix.getNom()));
		String[] donnees = control.libererEtal(obelix.getNom());
		assertNotNull(donnees);
		assertEquals("true", donnees[0]);
		assertEquals(obelix.getNom(), donnees[1]);
		assertEquals("fleurs", donnees[2]);
		assertEquals("5", donnees[3]);
		assertEquals("0", donnees[4]);
		
	}
	
	@Test
	public void testLibererEtalVendeurInconnu() {
		ControlLibererEtal control = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		Gaulois asterix = new Gaulois ("Astérix", 4);
		String[] donnees = control.libererEtal(asterix.getNom());
		assertEquals(false, control.isVendeur(asterix.getNom()));
		assertNull(donnees, "Erreur le venderur n'existe pas donc null");
	}

}
