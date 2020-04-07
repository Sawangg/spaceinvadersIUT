package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

    private static final char MARQUE_FIN_LIGNE = '\n';
    private static final char MARQUE_VIDE = '.';
    private static final char MARQUE_VAISSEAU = 'V';
    
    int longueur;
    int hauteur;
    Vaisseau vaisseau;

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

    public void positionnerUnNouveauVaisseau(final int x, final int y) {
		if (!estDansEspaceJeu(x, y)) {
            throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");
        }

        this.vaisseau = new Vaisseau(x, y);
	}

    private boolean estDansEspaceJeu(final int x, final int y) {
        return (((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur)));
    }

	public void deplacerVaisseauVersLaDroite() {
        if (vaisseau.abscisse() < (longueur - 1)) vaisseau.seDeplacerVersLaDroite();
    }

    
}