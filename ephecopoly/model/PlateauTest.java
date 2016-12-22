package ephecopoly.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlateauTest {
	
	Plateau plateau = new Plateau();
	Case cours = new Case(0, 0, null, null, 0, true);

	@Test
	public void test() {
		plateau.remplirListe(cours);
		assertEquals(cours, plateau.getListeCase().get(0));
	}

}
