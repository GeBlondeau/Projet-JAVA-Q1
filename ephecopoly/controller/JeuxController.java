package ephecopoly.controller;

import ephecopoly.model.*;
import ephecopoly.view.*;

public class JeuxController {
	
	private Jeux jeu;
	
	public JeuxVue vue = null;
	
	public JeuxController(Jeux model){
		this.jeu = model;
	}
	
	public void setEcts(Etudiant etudiant, int ects){
		jeu.setEcts(etudiant, ects);
		controlerCredit(etudiant);
	}
	public void setEtatPrison(Etudiant etudiant, int etatPrison){
		jeu.setEtatPrison(etudiant, etatPrison);
	}
	public void setPositionEtudiant(Etudiant etudiant, int positionJoueur){
		jeu.setPositionEtudiant(etudiant, positionJoueur);
		controlerPosition(etudiant);
	}
	public void setProprietaire(Etudiant proprietaire, Case cours){
		jeu.setProprietaire(proprietaire, cours);
	}
	public void setJeuEtudiant(Etudiant etudiant, boolean jeuEtudiant) {
		jeu.setEtatJeu(etudiant, jeuEtudiant);
	}
	public void setEtudiantActuel(Jeux jeu, Etudiant etudiantActuel) {
		jeu.setEtudiantActuel(etudiantActuel);
	}
	public void setEtatDes(Jeux jeu, Etudiant etudiant, boolean jeuEtudiant) {
		jeu.setEtatDes(etudiant, jeuEtudiant);
	}
	
	public void addView(JeuxVue vue){
		this.vue = vue;
	}
	public void controlerCredit(Etudiant etudiant){
		if (vue != null){
			if (jeu.getEcts(etudiant) <= 0){
				jeu.finDuJeu(etudiant);
			}
			else{
			}
		}
	}
	public void controlerPosition(Etudiant etudiant){
		if (vue != null){
			if(jeu.getPositionEtudiant(etudiant) < 40){
			}
			else {
				jeu.setPositionEtudiant(etudiant, jeu.getPositionEtudiant(etudiant) - 40);
			}
		}
	}
}
