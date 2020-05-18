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
        dessinerUnVaisseau(image);
        dessinerUnMissile(image);
	}

    private void dessinerUnVaisseau(BufferedImage image) {
        Vaisseau vaisseau = this.jeu.getVaisseau();
        if(vaisseau != null) {
            Graphics2D crayon = (Graphics2D) image.getGraphics();
            crayon.setColor(Color.RED);
            crayon.fillRect(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusBasse(), vaisseau.longueur(), vaisseau.hauteur());
        }
    }

    private void dessinerUnMissile(BufferedImage image) {
        Missile missile = this.jeu.getMissile();
        if(missile != null) {
            Graphics2D crayon = (Graphics2D) image.getGraphics();
            crayon.setColor(Color.BLUE);
            crayon.fillRect(missile.abscisseLaPlusAGauche(), missile.ordonneeLaPlusBasse(), missile.longueur(), missile.hauteur());
        }
    }
}