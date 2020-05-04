package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

	private final Position origine;
	private final Dimension dimension;

	public Vaisseau(final int longueur, final int hauteur) {
		this(longueur, hauteur, 0, 0);
	}

	public Vaisseau(final int longueur, final int hauteur, final int x, final int y) {
		this(new Dimension(longueur, hauteur), new Position(x, y));
	}

	public Vaisseau(final Dimension dimension, final Position positionOrigine) {
		this.dimension = dimension;
		this.origine = positionOrigine;
	}

	public boolean occupeLaPosition(final int x, final int y) {
		return estAbscisseCouverte(x) && estOrdonneeCouverte(y);
	}

	private boolean estOrdonneeCouverte(final int y) {
		return (ordonneeLaPlusBasse() <= y) && (y <= ordonneeLaPlusHaute());
	}

	private boolean estAbscisseCouverte(final int x) {
		return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
	}

	private int ordonneeLaPlusBasse() {
		return this.origine.ordonnee() - this.dimension.hauteur() + 1;
	}

	private int ordonneeLaPlusHaute() {
		return this.origine.ordonnee();
	}

	public int abscisseLaPlusADroite() {
		return this.origine.abscisse() + this.dimension.longueur() - 1;
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	public void seDeplacerVersLaDroite() {
		this.origine.changerAbscisse(this.origine.abscisse() + 1);
	}

	public void seDeplacerVersLaGauche() {
		this.origine.changerAbscisse(this.origine.abscisse() - 1);
	}

	public void positionner(final int x, final int y) {
		this.origine.changerAbscisse(x);
		this.origine.changerOrdonnee(y);
	}
}