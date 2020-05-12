package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvadersTest {
	
	private SpaceInvaders spaceinvaders;

	@Before
	public void initialisation() {
		this.spaceinvaders = new SpaceInvaders(15, 10);
	}

    @Test
    public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
		this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1, 1), new Position(7, 9), 1);
        assertEquals("" + 
        "...............\n" + 
        "...............\n" +
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        "...............\n" + 
        ".......V.......\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
    }

    @Test
	public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1, 1), new Position(15, 9), 1);
			fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1, 1), new Position(-1, 9), 1);
			fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1, 1), new Position(14, 10), 1);
			fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1, 1), new Position(14, -1), 1);
			fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
	}

	@Test
	public void test_unNouveauVaisseauAvecDimensionEstCorrectementPositionneDansEspaceJeu() {
		this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(7, 9), 1);
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		".......VVV.....\n" + 
		".......VVV.....\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
	
	@Test
	public void test_UnNouveauVaisseauPositionneDansEspaceJeuMaisAvecDimensionTropGrande_DoitLeverUneExceptionDeDebordement() {
		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(9, 2), new Position(7, 9), 1);
			fail("Dépassement du vaisseau à droite en raison de sa longueur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
		} catch (final DebordementEspaceJeuException e) {
		}
		
		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 4), new Position(7, 1), 1);
			fail("Dépassement du vaisseau vers le haut en raison de sa hauteur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
		} catch (final DebordementEspaceJeuException e) {
		}
			
	}

	@Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
		
		this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(12, 9), 3);
		this.spaceinvaders.deplacerVaisseauVersLaDroite();

		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"............VVV\n" + 
		"............VVV\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
	
	@Test
	public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {

		this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(7, 9), 3);
		this.spaceinvaders.deplacerVaisseauVersLaDroite();
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"..........VVV..\n" + 
		"..........VVV..\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

	@Test
    public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaDroite() {

       this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(10, 9), 3);
       this.spaceinvaders.deplacerVaisseauVersLaDroite();
       assertEquals("" + 
       "...............\n" + 
       "...............\n" +
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "............VVV\n" + 
       "............VVV\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}
	
	@Test
    public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {

		this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(7, 9), 3);
		this.spaceinvaders.deplacerVaisseauVersLaGauche();

    	assertEquals("" + 
    	"...............\n" + 
    	"...............\n" +
    	"...............\n" + 
    	"...............\n" + 
    	"...............\n" + 
    	"...............\n" + 
    	"...............\n" + 
    	"...............\n" + 
    	"....VVV........\n" + 
    	"....VVV........\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

	@Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {
		
		this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(0, 9), 3);
		this.spaceinvaders.deplacerVaisseauVersLaGauche();
		
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"VVV............\n" + 
		"VVV............\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

	@Test
    public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaGauche() {

		this.spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2),new Position(1, 9), 3);
		this.spaceinvaders.deplacerVaisseauVersLaGauche();

       assertEquals("" + 
       "...............\n" + 
       "...............\n" +
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "...............\n" + 
       "VVV............\n" + 
       "VVV............\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
     }
}