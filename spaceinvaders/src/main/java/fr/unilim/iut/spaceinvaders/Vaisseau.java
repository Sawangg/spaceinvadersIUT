package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

	private int x;
	private int y;
	private int longueur;
	private int hauteur;

	public Vaisseau(final int longueur, final int hauteur, final int x, final int y) {
		this.longueur = longueur;
		this.hauteur = hauteur;
		this.x = x;
		this.y = y;
	}

	public Vaisseau(final int longueur, final int hauteur) {
		this(longueur, hauteur, 0, 0);
	}


	public boolean occupeLaPosition(final int x, final int y) {
		return (estAbscisseCouverte(x) && estOrdonneeCouverte(y));
	}

	private boolean estAbscisseCouverte(final int x) {
		return (abscisseLaPlusAGauche() <= x && abscisseLaPlusADroite(x));
	}

	private boolean estOrdonneeCouverte(final int y) {
		return (ordonneeLaPlusBasse(y) && ordonneeLaPlusHaute(y));
	}

	private boolean ordonneeLaPlusBasse(final int y) {
		return y <= this.y;
	}

	private boolean ordonneeLaPlusHaute(final int y) {
		return this.y - this.hauteur + 1 <= y;
	}
	
	public boolean abscisseLaPlusADroite(final int x) {
		return (this.x <= x && x <= this.x + this.longueur - 1);
	}

	public void positionner(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public void seDeplacerVersLaDroite() {
		this.x = this.x + 1;
	}

	public void seDeplacerVersLaGauche() {
		this.x = this.x - 1;
	}

	public int abscisseLaPlusAGauche() {
		return this.x;
	}

	public int abscisseLaPlusADroite() {
		return this.x;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(final int y) {
		this.y = y;
	}

	public int getLongueur() {
		return this.longueur;
	}

	public void setLongueur(final int longueur) {
		this.longueur = longueur;
	}

	public int getHauteur() {
		return this.hauteur;
	}

	public void setHauteur(final int hauteur) {
        this.hauteur = hauteur;
    }





}
