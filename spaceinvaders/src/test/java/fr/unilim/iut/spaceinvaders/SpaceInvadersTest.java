package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

public class SpaceInvadersTest {
	
	private SpaceInvaders spaceinvaders;

	@Before
	public void initialisation() {
		this.spaceinvaders = new SpaceInvaders(15, 10);
	}

    @Test
    public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
        this.spaceinvaders.positionnerUnNouveauVaisseau(7,9);
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
			this.spaceinvaders.positionnerUnNouveauVaisseau(15,9);
			fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(-1,9);
			fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(14,10);
			fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		try {
			this.spaceinvaders.positionnerUnNouveauVaisseau(14,-1);
			fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
	}

	@Test
	public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {
		
		this.spaceinvaders.positionnerUnNouveauVaisseau(7,9);
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
		"...............\n" + 
		"........V......\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

	@Test
	public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
		
		this.spaceinvaders.positionnerUnNouveauVaisseau(14,9);
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
		"...............\n" + 
		"..............V\n" , this.spaceinvaders.recupererEspaceJeuDansChaineASCII());
	}

}