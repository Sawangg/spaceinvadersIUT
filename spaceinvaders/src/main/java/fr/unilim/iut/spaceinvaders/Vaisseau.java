package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

	private int x;
	private int y;

	public Vaisseau(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public boolean occupeLaPosition(final int x, final int y) {
        return (this.x == x) && (this.y == y);
    }

	public void seDeplacerVersLaDroite() {
		this.x = this.x + 1;	
	}


    public int abscisse() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
