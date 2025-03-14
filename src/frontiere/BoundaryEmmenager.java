package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}
	

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur);
					StringBuilder force = new StringBuilder();
					force.append("Quelle est votre force ?\n");
					int forceG = Clavier.entrerEntier(force.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceG);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue Druide " + nomVisiteur);
		StringBuilder force = new StringBuilder();
		force.append("Quelle est votre force ?");
		int forceDruide = Clavier.entrerEntier(force.toString());
		
		StringBuilder PotionFaible = new StringBuilder();
		PotionFaible.append("Quelle est la force de potion la plus faible que vous produisez ?");
		int forcePotionFaible = Clavier.entrerEntier(PotionFaible.toString());
		
		StringBuilder PotionForte = new StringBuilder();
		PotionForte.append("Quelle est la force de potion la plus forte que vous produisez ?");
		int forcePotionForte = Clavier.entrerEntier(PotionForte.toString());
		
		if(forcePotionFaible > forcePotionForte) {
			System.out.println("Attention Druide , vous vous êtes trompé entre le minimum et le maximum ");
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, forcePotionFaible, forcePotionForte);
		
	}

}
