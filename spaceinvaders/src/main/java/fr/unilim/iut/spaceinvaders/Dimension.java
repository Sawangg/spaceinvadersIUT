package fr.unilim.iut.spaceinvaders;

public class Dimension {
    private final int longueur;
    private final int hauteur;

    public Dimension(final int longueur, final int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
    }

    public int longueur() {
        return this.longueur;
    }

    public int hauteur() {
      return this.hauteur;
    }

 }  
