package fr.unilim.iut.spaceinvaders;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fr.unilim.iut.spaceinvaders.moteur.DessinJeu;

public class DessinSpaceInvaders implements DessinJeu {

    private SpaceInvaders jeu;

    public DessinSpaceInvaders(SpaceInvaders spaceInvaders) {
           this.jeu = spaceInvaders;
    }

	@Override
	public void dessiner(BufferedImage image) {
		Vaisseau v = this.jeu.getVaisseau();
		Graphics2D crayon = (Graphics2D) image.getGraphics();
        crayon.setColor(Color.BLUE);
        crayon.fillRect(v.abscisseLaPlusAGauche(), v.ordonneeLaPlusBasse(), v.longueur(), v.hauteur());
	}
}