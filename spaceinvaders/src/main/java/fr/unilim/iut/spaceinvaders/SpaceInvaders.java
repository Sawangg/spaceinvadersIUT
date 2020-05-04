package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

    private static final char MARQUE_FIN_LIGNE = '\n';
    private static final char MARQUE_VIDE = '.';
    private static final char MARQUE_VAISSEAU = 'V';
    
    private final int longueur;
    private final int hauteur;
    private Vaisseau vaisseau;

    public SpaceInvaders(final int longueur, final int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
    }

    @Override
    public String toString() {
        return this.recupererEspaceJeuDansChaineASCII();
    }

    public String recupererEspaceJeuDansChaineASCII() {
        final StringBuilder espaceDeJeu = new StringBuilder();
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < longueur; x++) {
                espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
            }
            espaceDeJeu.append(MARQUE_FIN_LIGNE);
        }
        return espaceDeJeu.toString();
    }

    private char recupererMarqueDeLaPosition(final int x, final int y) {
        char marque;
        if (this.aUnVaisseauQuiOccupeLaPosition(x, y)) {
            marque = MARQUE_VAISSEAU;
        } else {
            marque = MARQUE_VIDE;
        }
        return marque;
    }

    private boolean aUnVaisseauQuiOccupeLaPosition(final int x, final int y) {
        return this.aUnVaisseau() && this.vaisseau.occupeLaPosition(x, y);
    }

    private boolean aUnVaisseau() {
        return this.vaisseau != null;
    }

    private boolean estDansEspaceJeu(final int x, final int y) {
        return (((x >= 0) && (x < this.longueur)) && ((y >= 0) && (y < this.hauteur)));
    }

	public void deplacerVaisseauVersLaDroite() {
		if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
			vaisseau.seDeplacerVersLaDroite();
        }
	}

	public void deplacerVaisseauVersLaGauche() {
        if (this.vaisseau.abscisseLaPlusAGauche() > 0) {
            this.vaisseau.seDeplacerVersLaGauche();
        } 
	}

	public void positionnerUnNouveauVaisseau(int longueur, int hauteur, int x, int y) {
        if (!estDansEspaceJeu(x, y)) {
            throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");
        }

        if (!estDansEspaceJeu(x + longueur -1, y)) {
			throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
        }
		if (!estDansEspaceJeu(x ,y - hauteur + 1)) {
            throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");
        }    
        vaisseau = new Vaisseau(longueur, hauteur);
        vaisseau.positionner(x, y);
    }

    
}