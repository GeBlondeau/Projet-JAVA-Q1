package ephecopoly.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaseTest {
	
	Case cours = new Case(0, 0, null, null, 0, true);
	Etudiant etudiant = new Etudiant(0, 0, 0, "etudiant", true, true);

	@Test
	public void test() {
		assertEquals(null, cours.getProprietaire());
		cours.setProprietaire(etudiant);
		assertEquals(etudiant, cours.getProprietaire());
	}
}
