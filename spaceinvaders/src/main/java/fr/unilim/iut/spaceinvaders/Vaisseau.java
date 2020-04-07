package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

	int x;
	int y;

	public Vaisseau(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public boolean occupeLaPosition(final int x, final int y) {
        return (this.x == x) && (this.y == y);
    }
    
}
