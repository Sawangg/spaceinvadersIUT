package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class Vaisseau extends Sprite {
	
	public Vaisseau(final Dimension dimension, final Position positionOrigine, final int vitesse) {
		super(dimension, positionOrigine, vitesse);
	}

    public Missile tirerUnMissile(final Dimension dimensionMissile, final int vitesseMissile) {
		final Position positionOrigineMissile = positionOrigineMissile(dimensionMissile);
		if(dimensionMissile.longueur() > this.longueur()) throw new MissileException("La longueur du missile est supérieure à celle du vaisseau");
		return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
	}

	private Position positionOrigineMissile (final Dimension dimensionMissile) {
		final int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
		final int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);

		final int ordonneeeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
		final Position positionOrigineMissile = new Position(abscisseOrigineMissile, ordonneeeOrigineMissile);
		return positionOrigineMissile;
	}
}