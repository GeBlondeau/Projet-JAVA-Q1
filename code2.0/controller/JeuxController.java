package ephecopoly.controller;

import ephecopoly.model.*;
import ephecopoly.view.*;

public class JeuxController {
	
	private Jeux jeu;
	private Etudiant etudiant;
	private Case cours;
	private Plateau plateau;
	public JeuxVue vue = null;
	
	public JeuxController(Jeux model, Etudiant etudiant, Case cours, Plateau plateau){
		this.jeu = model;
		this.etudiant = etudiant;
		this.cours = cours;
		this.plateau = plateau;
	}
	
	public void setEcts(int ects){
		etudiant.setEcts(ects);
		controlerCredit();
	}
	public void setEtatPrison(int etatPrison){
		etudiant.setEtatPrison(etatPrison);
	}
	public void setPositionEtudiant(int positionJoueur){
		etudiant.setPositionEtudiant(positionJoueur);
		controlerPosition();
	}
	public void setProprietaire(Etudiant proprietaire){
		cours.setProprietaire(proprietaire);
	}
	
	
	public void addView(JeuxVue vue){
		this.vue = vue;
	}
	public void controlerCredit(){
		if (vue != null){
			if (etudiant.getEcts() <=0){
				jeu.finDuJeu();
			}
		}
	}
	public void controlerPosition(){
		if (vue != null){
			if(etudiant.getPositionEtudiant() < 40){
			}
			else {
				etudiant.setPositionEtudiant(etudiant.getPositionEtudiant() - 40);
			}
		}
	}
}
