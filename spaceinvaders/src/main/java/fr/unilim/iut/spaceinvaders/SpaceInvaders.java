package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;
import fr.unilim.iut.spaceinvaders.moteur.Commande;
import fr.unilim.iut.spaceinvaders.moteur.Jeu;

public class SpaceInvaders implements Jeu {
    
    private final int longueur;
    private final int hauteur;
    private Vaisseau vaisseau;
    private Missile missile;

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
        } else if(commandeUser.tir && !this.aUnMissile()) {
            this.tirerUnMissile(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR), Constante.MISSILE_VITESSE);
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

    private char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPosition(x, y)) {
			marque = Constante.MARQUE_VAISSEAU;

        } else if (this.aUnMissileQuiOccupeLaPosition(x, y)) {
            marque = Constante.MARQUE_MISSILE;
        } else  {
            marque = Constante.MARQUE_VIDE;
        }    
		return marque;
	}

    private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
        return this.aUnMissile() && this.missile.occupeLaPosition(x, y);
    }

    private boolean aUnMissile() {
        return this.missile != null;
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
		if (this.vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
            this.vaisseau.seDeplacerVersLaDroite();
            if (!estDansEspaceJeu(this.vaisseau.abscisseLaPlusADroite(), this.vaisseau.ordonneeLaPlusHaute())) {
				this.vaisseau.positionner(longueur - this.vaisseau.longueur(), this.vaisseau.ordonneeLaPlusHaute());
			}
        }
	}

	public void deplacerVaisseauVersLaGauche() {
        if (this.vaisseau.abscisseLaPlusAGauche() > 0) {
            this.vaisseau.seDeplacerVersLaGauche();
            if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(),this.vaisseau.ordonneeLaPlusHaute())) {
                this.vaisseau.positionner(0, this.vaisseau.ordonneeLaPlusHaute());
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

        this.vaisseau = new Vaisseau(dimension, position, vitesse);
        this.vaisseau.positionner(x, y);
	}

    public Vaisseau getVaisseau() {
    	return this.vaisseau;
    }

    public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
        if ((vaisseau.hauteur()+ dimensionMissile.hauteur()) > this.hauteur ) {
            throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");
        }
        this.missile = this.vaisseau.tirerUnMissile(dimensionMissile, vitesseMissile);
	}

	public Missile getMissile() {
		return this.missile;
	}

}