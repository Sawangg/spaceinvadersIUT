package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.moteur.Commande;
import fr.unilim.iut.spaceinvaders.moteur.Jeu;

public class SpaceInvaders implements Jeu {
    
    private final int longueur;
    private final int hauteur;
    private Vaisseau vaisseau;

    public SpaceInvaders(final int longueur, final int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
    }
    
	public void initialiserJeu() {
		Position positionVaisseau = new Position(this.longueur / 2, this.hauteur - 1);
		Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
		positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
	 }
	
	@Override
	public void evoluer(Commande commandeUser) {
		if(commandeUser.droite) {
			this.deplacerVaisseauVersLaDroite();
		} else if(commandeUser.gauche) {
            this.deplacerVaisseauVersLaGauche();
        }
	}

	@Override
	public boolean etreFini() {
		return false;
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
            espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
        }
        return espaceDeJeu.toString();
    }

    private char recupererMarqueDeLaPosition(final int x, final int y) {
        char marque;
        if (this.aUnVaisseauQuiOccupeLaPosition(x, y)) {
            marque = Constante.MARQUE_VAISSEAU;
        } else {
            marque = Constante.MARQUE_VIDE;
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
            if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
				vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
			}
        }
	}

	public void deplacerVaisseauVersLaGauche() {
        if (this.vaisseau.abscisseLaPlusAGauche() > 0) {
            this.vaisseau.seDeplacerVersLaGauche();
            if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
                vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
            }
        } 
	}

    public void positionnerUnNouveauVaisseau(final Dimension dimension, final Position position, final int vitesse) {

        final int x = position.abscisse();
        final int y = position.ordonnee();

        if (!estDansEspaceJeu(x, y))
            throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

        final int longueurVaisseau = dimension.longueur();
        final int hauteurVaisseau = dimension.hauteur();
		
		if (!estDansEspaceJeu(x + longueurVaisseau - 1, y)) {
			throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
        }
		if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1)) {
			throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");
        }

        vaisseau = new Vaisseau(dimension, position, vitesse);
        vaisseau.positionner(x, y);
	}

    public Vaisseau getVaisseau() {
    	return this.vaisseau;
    }

}