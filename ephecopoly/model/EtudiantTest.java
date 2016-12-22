package ephecopoly.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EtudiantTest {
	
	Etudiant etudiant = new Etudiant(0, 0, 0, null, false, false);

	@Test
	public void test() {
		assertEquals(0, etudiant.getEcts());
		etudiant.setEcts(100);
		assertEquals(100, etudiant.getEcts());
		
		assertEquals(false, etudiant.getEtatDes());
		etudiant.setEtatDes(true);
		assertEquals(true, etudiant.getEtatDes());
		
		assertEquals(false, etudiant.getEtatJeu());
		etudiant.setEtatJeu(true);
		assertEquals(true, etudiant.getEtatJeu());
		
		assertEquals(0, etudiant.getEtatPrison());
		etudiant.setEtatPrison(4);
		assertEquals(4, etudiant.getEtatPrison());
		
		assertEquals(0, etudiant.getPositionEtudiant());
		etudiant.setPositionEtudiant(15);
		assertEquals(15, etudiant.getPositionEtudiant());
	}

}
