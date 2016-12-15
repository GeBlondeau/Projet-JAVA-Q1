package ephecopoly.view;

import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import ephecopoly.controller.JeuxController;
import ephecopoly.model.*;

public class JeuxVueConsole extends JeuxVue implements Observer {
	
	protected Scanner sc;
	
	public JeuxVueConsole(Jeux model, JeuxController controller){
		super(model, controller);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();
	}
	
	@Override
	public void affiche(String string){
		System.out.println(string);
	}
	@Override
	public void update(Observable o, Object arg) {
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			Jeux jeu = new Jeux();
			Plateau plateau = new Plateau();
			
			jeu.lancerJeu();
			plateau.creationPlateau();
				while(true){
					for (Etudiant etudiant: jeu.getListeEtudiant()){
						if(jeu.getJeuEtudiant(etudiant)){
							affiche("====================================================================================");
							try{
								if(jeu.getJeuEtudiant(etudiant)){
									affiche("Etudiant : " + jeu.getNomEtudiant(etudiant));
									if(jeu.getEtatPrison(etudiant) == 0){
										affiche("Pour lancer les dés appuyer sur une touche et faite enter");
										String c = sc.next();
										if(c.length()!= 0){
											int deplacement = jeu.lanceDes(etudiant);
											affiche("La valeur des dés est " + deplacement);
											controller.setPositionEtudiant(etudiant, jeu.getPositionEtudiant(etudiant) + deplacement);
											
											Case cours = jeu.getListeCase(plateau).get(jeu.getPositionEtudiant(etudiant));
											
											if(jeu.getAchetable(cours) && jeu.getProprietaire(cours) == null 
													&& jeu.getEcts(etudiant) >= jeu.getPrixAchat(cours)){
												affiche("La case coute " + jeu.getPrixAchat(cours) + " ects.");
												affiche("La case rapporte " + jeu.getPrixLoyer(cours) + " ects.");
												affiche("Il vous reste " + jeu.getEcts(etudiant) +" ects.");
												affiche("Acheter la case : Oui - Non");
												
												boolean	format = true;
												while(format){
													String achat = sc.next();
													if(achat.length()==3)
														switch(achat){
														case "Oui" :
															jeu.setEcts(etudiant, -cours.getPrixAchat());
															jeu.setProprietaire(etudiant, cours);
															format = false;
															break;
														case "Non" :
															format = false;
															affiche("Dommage on se revoit en août !");
															break;
														default :
														}
														else ;
												}
												
												affiche("Il vous reste " + jeu.getEcts(etudiant) + " ects");
											}
											else if(jeu.getAchetable(cours) && jeu.getProprietaire(cours) == null 
													&& jeu.getEcts(etudiant) < jeu.getPrixAchat(cours)){
												affiche("Vous n'avez pas assez d'ects pour tenter de passer ce cours");
												affiche("Vous avez toujours " + jeu.getEcts(etudiant) + " ects.");
											}
											else if(jeu.getAchetable(cours) && jeu.getProprietaire(cours) == etudiant){
												affiche("Vous avez déjà réussi ce cours");
												affiche("Vous avez toujours " + jeu.getEcts(etudiant) + " ects.");
											}
											else if(jeu.getAchetable(cours) && jeu.getProprietaire(cours) != null){
												affiche("Le cours a déjà été réussi par : " 
														+ jeu.getNomEtudiant(jeu.getProprietaire(cours)) + ".");
												int loyer = jeu.getPrixLoyer(cours);
												jeu.setEcts(etudiant, -loyer);
												jeu.getProprietaire(cours).setEcts(loyer);
												affiche("Vous devez lui payer : " + loyer + " ects.");
												affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
											}
											else {
												int position = jeu.getPositionCase(cours);
												switch(position){
												case 0 : 
													controller.setEcts(etudiant, cours.getPrixLoyer());
													affiche("Vous venez de recevoir " + jeu.getPrixLoyer(cours) 
														+ "ects, vous avez maintenant " 
														+ jeu.getEcts(etudiant) + " ects.");
													break;
												case 2 :
													controller.setEcts(etudiant, -(cours.getPrixLoyer() * deplacement));
													affiche("Interro surprise, vous ratez " + jeu.getPrixLoyer(cours) * deplacement + " ects.");
													affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 4 :
													controller.setEcts(etudiant, -(cours.getPrixLoyer()));
													affiche("Vous arrivez en retard à l'examen, vous ratez " 
															+ jeu.getPrixLoyer(cours) + " ects.");
													affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 7 :
													controller.setEcts(etudiant, deplacement);
													affiche("Félicitation vous avez " + deplacement + " ects en plus.");
													affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 10 :
													affiche("Vous visitez la prison.");
													affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
													break;
												case 17 :
													controller.setEcts(etudiant, -(cours.getPrixLoyer() * deplacement));
													affiche("Interro surprise, vous ratez " + jeu.getPrixLoyer(cours) * deplacement + " ects.");
													affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 20 :
													affiche("Félicitation vous avez trouver une place de parking "
															+ "gratuit autour de l'ephec.");
													affiche("Vous avez toujours " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 22 :
													controller.setEcts(etudiant, deplacement);
													affiche("Félicitation vous avez " + deplacement + " ects en plus.");
													affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 30 :
													controller.setPositionEtudiant(etudiant, 10);
													controller.setEtatPrison(etudiant, 2);
													affiche("Aller directement en prison sans passer par la case départ,"
															+ " vous resterez emprisonner 2 tours.");
													affiche("Vous avez toujours " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 33 :
													controller.setEcts(etudiant, -(cours.getPrixLoyer() * deplacement));
													affiche("Interro surprise, vous ratez " + jeu.getPrixLoyer(cours) * deplacement + " ects.");
													affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 36 :
													controller.setEcts(etudiant, deplacement);
													affiche("Félicitation vous avez " + deplacement + " ects en plus.");
													affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
													break;
												case 38 :
													controller.setEcts(etudiant, -(cours.getPrixLoyer()));
													affiche("Vous arrivez en retard à l'examen, vous ratez " 
															+ jeu.getPrixLoyer(cours) + " ects.");
													affiche("Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
													break;
												default :
												}
											}
										}
									}
									else {
										controller.setEtatPrison(etudiant, jeu.getEtatPrison(etudiant)-1);
									}
								}
								else {
									affiche("L'étudiant " + jeu.getNomEtudiant(etudiant) + " a déjà été éliminer.");
									break;
								}
							}
							catch(InputMismatchException e){
							affiche("Format d'input incorrect error1.");
							}
						}
					}
				}
		}
	}
}
