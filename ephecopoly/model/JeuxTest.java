package ephecopoly.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class JeuxTest {
	
	Jeux jeu = new Jeux();
	Etudiant etudiant = new Etudiant(0, 0, 0, null, true, true);
	Case cours = new Case(0, 0, null, null, 0, true);

	@Test
	public void test() {
		assertEquals(0, jeu.getEcts(etudiant));
		jeu.setEcts(etudiant, 10);
		assertEquals(10, jeu.getEcts(etudiant));
		
		assertEquals(true, jeu.getEtatDes(etudiant));
		jeu.setEtatDes(etudiant, false);
		assertEquals(false, jeu.getEtatDes(etudiant));
		
		assertEquals(true, jeu.getEtatJeu(etudiant));
		jeu.setEtatJeu(etudiant, false);
		assertEquals(false, jeu.getEtatJeu(etudiant));
		
		assertEquals(0, jeu.getEtatPrison(etudiant));
		jeu.setEtatPrison(etudiant, 2);
		assertEquals(2, jeu.getEtatPrison(etudiant));
		
		assertEquals(null, jeu.getEtudiantActuel());
		jeu.setEtudiantActuel(etudiant);
		assertEquals(etudiant, jeu.getEtudiantActuel());
		
		assertEquals(null, jeu.getJeuString());
		jeu.setJeuString("test ");
		assertEquals("test ", jeu.getJeuString());
		
		assertEquals("test ", jeu.getJeuString());
		jeu.addJeuString("jeux");
		assertEquals("test jeux", jeu.getJeuString());
		
		assertEquals(0, jeu.getPositionEtudiant(etudiant));
		jeu.setPositionEtudiant(etudiant, 10);
		assertEquals(10, jeu.getPositionEtudiant(etudiant));
		
		assertEquals(null, jeu.getProprietaire(cours));
		jeu.setProprietaire(etudiant, cours);
		assertEquals(etudiant, jeu.getProprietaire(cours));
	}

}
