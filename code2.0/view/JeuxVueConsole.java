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
		System.out.println(model);
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			Jeux jeu = new Jeux();
			Plateau plateau = new Plateau();
			
			jeu.lancerJeu();
			plateau.creationPlateau();
				while(true){
					for (Etudiant etudiant: jeu.getListeEtudiant()){
						affiche("====================================================================================");
						try{
							affiche("Etudiant : " + etudiant.getNomEtudiant());
							if(etudiant.getEtatPrison() == 0){
								affiche("Pour lancer les dés appuyer sur une touche et faite enter");
								String c = sc.next();
								if(c.length()!=0){
									int deplacement = etudiant.lanceDes();
									controller.setPositionEtudiant(etudiant.getPositionEtudiant() + deplacement);
									
									Case cours = plateau.getListeCase().get(etudiant.getPositionEtudiant());
									
									if(cours.getAchetable() && cours.getProprietaire() == null){
										affiche("La case coute " + cours.getPrixAchat() + " ects.");
										affiche("La case rapporte " + cours.getPrixLoyer() + " ects.");
										affiche("Il vous reste " + etudiant.getEcts() +" ects.");
										
										boolean	format = true;
										while(format){
											String achat = sc.next();
											if(achat.length()==3)
												switch(achat){
												case "Oui" :
													etudiant.setEcts(-cours.getPrixAchat());
													cours.setProprietaire(etudiant);
													format = false;
													break;
												case "Non" :
													format = false;
													break;
												default :
												}
												else ;
										}
										
										affiche("Il vous reste " + etudiant.getEcts() + " ects");
									}
									else if(cours.getAchetable() && cours.getProprietaire() == etudiant){
										affiche("Vous avez déjà réussi ce cours");
										affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
									}
									else if(cours.getAchetable() && cours.getProprietaire() != null){
										int loyer = cours.getPrixLoyer();
										etudiant.setEcts(-loyer);
										cours.getProprietaire().setEcts(loyer);
									}
									else {
										int position = cours.getPositionCase();
										switch(position){
										case 0 : 
											controller.setEcts(cours.getPrixLoyer());
											affiche("Vous venez de recevoir 25 ects, vous avez maintenant " 
													+ etudiant.getEcts() + " ects.");
											break;
										case 2 :
											controller.setEcts(-(cours.getPrixLoyer() * deplacement));
											affiche("Interro surprise, vous ratez " + cours.getPrixLoyer() * deplacement + " ects.");
											affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
											break;
										case 4 :
											controller.setEcts(-(cours.getPrixLoyer()));
											affiche("Vous arrivez en retard à l'examen, vous ratez " 
													+ cours.getPrixLoyer() + " ects.");
											affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
											break;
										case 7 :
											controller.setEcts(deplacement);
											affiche("Félicitation vous avez " + deplacement + " ects en plus.");
											affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
											break;
										case 10 :
											affiche("Vous visitez la prison.");
											affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
											break;
										case 17 :
											controller.setEcts(-(cours.getPrixLoyer() * deplacement));
											affiche("Interro surprise, vous ratez " + cours.getPrixLoyer() * deplacement + " ects.");
											affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
											break;
										case 20 :
											affiche("Félicitation vous avez trouver une place de parking "
													+ "gratuit autour de l'ephec.");
											affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
											break;
										case 22 :
											controller.setEcts(deplacement);
											affiche("Félicitation vous avez " + deplacement + " ects en plus.");
											affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
											break;
										case 30 :
											controller.setPositionEtudiant(10);
											controller.setEtatPrison(2);
											affiche("Aller directement en prison sans passer par la case départ,"
													+ " vous resterez emprisonner 2 tours.");
											affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
											break;
										case 33 :
											controller.setEcts(-(cours.getPrixLoyer() * deplacement));
											affiche("Interro surprise, vous ratez " + cours.getPrixLoyer() * deplacement + " ects.");
											affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
											break;
										case 36 :
											controller.setEcts(deplacement);
											affiche("Félicitation vous avez " + deplacement + " ects en plus.");
											affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
											break;
										case 38 :
											controller.setEcts(-(cours.getPrixLoyer()));
											affiche("Vous arrivez en retard à l'examen, vous ratez " 
													+ cours.getPrixLoyer() + " ects.");
											affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
											break;
										default :
										}
									}
								}
							}
							else {
								controller.setEtatPrison(etudiant.getEtatPrison()-1);
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
