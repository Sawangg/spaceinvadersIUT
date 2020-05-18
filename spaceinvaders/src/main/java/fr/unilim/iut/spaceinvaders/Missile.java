package fr.unilim.iut.spaceinvaders;

public class Missile extends Sprite {

	public Missile(final Dimension dimensionMissile, final Position positionOrigineMissile, final int vitesseMissile) {
        super(dimensionMissile, positionOrigineMissile, vitesseMissile);
	}
    
    public Dimension getDimensionMissile() {
        return this.dimension;
    }

    public Position getPositionOrigineMissile() {
        return this.origine;
    }

    public int getVitesseMissile() {
        return this.vitesse;
    }

}