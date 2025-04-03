package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		String[] infoVendeur = controlLibererEtal.libererEtal(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!");
		}
		else {
			System.out.println("Vous avez vendu " + infoVendeur[4] + " sur " + infoVendeur[3] + " " + infoVendeur[2] + "." );
			System.out.println("Au revoir " + nomVendeur + " , passez une bonne journée");
			
		}
	}

}
