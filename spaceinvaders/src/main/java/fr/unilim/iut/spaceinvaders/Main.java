package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.moteur.MoteurGraphique;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		SpaceInvaders jeu = new SpaceInvaders(Constante.ESPACEJEU_LONGUEUR, Constante.ESPACEJEU_HAUTEUR);
		jeu.initialiserJeu();
		DessinSpaceInvaders aff = new DessinSpaceInvaders(jeu);

		MoteurGraphique moteur = new MoteurGraphique(jeu, aff);
		moteur.lancerJeu(400, 400);
	}

}
