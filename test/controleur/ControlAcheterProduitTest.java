package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois asterix;
	private Gaulois obelix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisaton ...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		asterix = new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "fleurs", 10);
	}
	
	@Test
	public void testControlAcheterProduit() {
		ControlAcheterProduit produit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
		assertNotNull(produit, "Erreur , un constructeur ne peut jamais être null");
	}
	
	@Test
	public void testVerifierIdentite() {
		ControlAcheterProduit produit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
		String nom = asterix.getNom();
		produit.verifierIdentite(nom);
		assertNotNull(nom);
		assertEquals(true, produit.verifierIdentite(nom));
	}
	
	@Test
	public void testrechercherVendeursParProduit() {
		ControlAcheterProduit produit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
		Gaulois[] vendeurs = produit.rechercherVendeursParProduit("fleurs");
		assertEquals(obelix, vendeurs[0]);
	}
	
	@Test
	public void testrechercherEtal() {
		ControlAcheterProduit produit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
		Etal etal = produit.rechercherEtal(obelix.getNom());
		assertNotNull(etal);
	}
	
	@Test
	public void testacheterProduit() {
		ControlAcheterProduit produit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
		int qte = produit.acheterProduit("Obélix", 3);
		assertEquals(3, qte);
	}
	
	@Test
	public void testacheterProduitSup() {
		ControlAcheterProduit produit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
		int qte = produit.acheterProduit("Obélix", 11);
		assertEquals(10, qte);
	}
	
	@Test
	public void testdonnerEtatMarche() {
		ControlAcheterProduit produit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
		String[] etat = produit.donnerEtatMarche();
		assertEquals(3,etat.length);
		assertEquals(obelix.getNom(), etat[0]);
		assertEquals("10", etat[1]);
		assertEquals("fleurs", etat[2]);
	}
	
}
