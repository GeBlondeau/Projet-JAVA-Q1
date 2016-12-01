package Projet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Jeux{

	static Scanner sc = new Scanner(System.in);
	static List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
	
	public void remplirListe(Etudiant joueur){
		listeEtudiant.add(joueur);
	}
	public void lancementJeu(){
		Jeux jeu = new Jeux();
		Etudiant Etudiant1 = new Etudiant(100, 0, 0,"Le Bon");
		Etudiant Etudiant2 = new Etudiant(100, 0, 0,"La Brute");
		//Etudiant Etudiant3 = new Etudiant(100, 0, 0,"Le Truand");
		//Etudiant Etudiant4 = new Etudiant(100, 0, 0,"Pour réussir l'année");
		jeu.remplirListe(Etudiant1);
		jeu.remplirListe(Etudiant2);
		//jeu.remplirListe(Etudiant3);
		//jeu.remplirListe(Etudiant4);
	}
	
	public static void affiche(String string){
		System.out.println(string);
	}
	
	public static void main(String[] args){
		Jeux jeu = new Jeux();
		Plateau plateau = new Plateau();
		
		jeu.lancementJeu();
		plateau.creationPlateau();
		
			while(true){
				for (Etudiant etudiant: listeEtudiant){
					affiche("===========================================================");
					try{
						
						affiche("Joueur : " + etudiant.getNomEtudiant());
						
						if(etudiant.getEtatPrison() == 0){
							
							affiche("Pour lancer les dés appuyer sur une ou plusieurs touches du clavier et faites enter.");
							String c = sc.next();
							if(c.length()!=0){
								int deplacement = etudiant.lanceDes();
								affiche("La valeur des dés est : " + deplacement + ".");
								etudiant.setPositionJoueur(etudiant.getPositionJoueur() + deplacement);
								
								if(etudiant.getPositionJoueur() < 40);
								else {etudiant.setPositionJoueur(-40);
									etudiant.setEcts(15);}
								Case cours = plateau.listeCase.get(etudiant.getPositionJoueur());
								affiche("Vous êtes arrivé sur " + cours.getNomCase() + ".");
								
								if(cours.getAchetable() && cours.getProprietaire() == null){
									affiche("La case coute " + cours.getPrixAchat() + " ects.");
									affiche("Il vous reste " + etudiant.getEcts() +" ects.");
									
									boolean	format2 = true;
									while(format2){
										try{
											affiche("Etudier pour l'examen oui : Y, non : N.");
											String achat = sc.next();
											if(achat.length()==1){
												switch(achat){
												case "Y" :
													etudiant.setEcts( - cours.getPrixAchat());
													cours.setProprietaire(etudiant.getNomEtudiant());
													affiche("Félicitation vous venez de réussir le cours de " 
															+ cours.getNomCase() + ".");
													affiche("Il vous reste " + etudiant.getEcts() + " ects.");
													format2 = false;
													break;
												case "N" :
													affiche("Dommage, on se revois en août!");
													format2 = false;
													break;
												default :
													affiche("Format d'input incorrect error5.");
												}	
											}
											else 
												affiche("Format d'input incorrect error4.");
										}
										catch(InputMismatchException f){
											affiche("Format d'input incorrect error3.");
										}
									}
								}
								else if(cours.getAchetable() && cours.getProprietaire() != null){
									affiche("Le cours a déjà été réussi par : " + cours.getProprietaire() + ".");
									int loyer = cours.getPrixLoyer();
									etudiant.setEcts(loyer);
									affiche("Vous devez lui payer : " + loyer + " ects.");
								}
								else {
									int position = cours.getPositionCase();
									switch(position){
									case 0 : 
										etudiant.setEcts(cours.getPrixLoyer());
										affiche("Vous venez de recevoir 25 ects, vous avez maintenant " 
												+ etudiant.getEcts() + " ects.");
										break;
									case 2 :
										int interro1 = cours.getPrixLoyer() * deplacement;
										etudiant.setEcts(interro1);
										affiche("Interro surprise, vous ratez " + interro1 + " ects.");
										affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
										break;
									case 4 :
										int examen1 = cours.getPrixLoyer();
										etudiant.setEcts(examen1);
										affiche("Vous arrivez en retard à l'examen, vous ratez " 
												+ examen1 + " ects.");
										affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
										break;
									case 7 :
										etudiant.setEcts(deplacement);
										affiche("Félicitation vous avez " + deplacement + " ects en plus.");
										affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
									case 10 :
										affiche("Vous visitez la prison.");
										affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
										break;
									case 17 :
										int interro2 = cours.getPrixLoyer() * deplacement;
										etudiant.setEcts(-interro2);
										affiche("Interro surprise, vous ratez " + interro2 + " ects.");
										affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
										break;
									case 20 :
										affiche("Félicitation vous avez trouver une place de parking "
												+ "gratuit autour de l'ephec.");
										affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
										break;
									case 22 :
										etudiant.setEcts(- deplacement);
										affiche("Dommage vous avez " + deplacement + " ects en moins.");
										affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
										break;
									case 30 :
										etudiant.setPositionJoueur(10);
										etudiant.setEtatPrison(2);
										affiche("Aller directement en prison sans passer par la case départ,"
												+ " vous resterez emprisonner 2 tours.");
										affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
										break;
									case 33 :
										int interro3 = cours.getPrixLoyer() * deplacement;
										etudiant.setEcts(interro3);
										affiche("Interro surprise, vous ratez " + interro3 + " ects.");
										affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
										break;
									case 36 :
										etudiant.setEcts(deplacement);
										affiche("Félicitation vous avez " + deplacement + " ects en plus.");
										affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
										break;
									case 38 :
										int examen2 = cours.getPrixLoyer();
										etudiant.setEcts(examen2);
										affiche("Vous arrivez en retard à l'examen, vous ratez " 
												+ examen2 + " ects.");
										affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
										break;
									default :
										affiche("error position case1.");
									}
								}
								
							}
								
							else {
							affiche("Format d'input incorrect error2.");
							break;
							}
						}
						else {
							etudiant.setEtatPrison(etudiant.getEtatPrison()-1);
							affiche("Vous êtes en Prison pour encore : " + etudiant.getEtatPrison() + " tour(s).");
						}
					}
					catch(InputMismatchException e){
					affiche("Format d'input incorrect error1.");
					}
					
				}
			
			}
		
	}
}