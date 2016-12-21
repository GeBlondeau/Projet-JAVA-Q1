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
	public void affiche(Jeux jeu, String string){
		System.out.println(string);
		jeu.addJeuString(string);
	}
	@Override
	public void update(Observable o, Object arg) {
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			Jeux jeu = new Jeux();
			Plateau plateau = new Plateau();
			
			jeu.lancerJeu();
			jeu.creationPlateau(plateau);
				while(true){
					jeu.setJeuString(null);
					for (Etudiant etudiant: jeu.getListeEtudiant()){
						controller.setEtudiantActuel(jeu, etudiant);
						try{
							if(jeu.getEtatJeu(etudiant) && jeu.getEtatPrison(etudiant) == 0){
								affiche(jeu, "============================================"
										+ "========================================");
								affiche(jeu, "Etudiant : " + jeu.getNomEtudiant(etudiant));
								affiche(jeu, "Pour lancer les dés appuyer sur une touche et faite enter");
								String c = sc.nextLine();
								if (c != null || jeu.getEtatDes(etudiant)){
									controller.setEtatDes(jeu, etudiant, false);
									int deplacement = jeu.lanceDes(etudiant);
									affiche(jeu, "La valeur des dés est " + deplacement);
									controller.setPositionEtudiant(etudiant, jeu.getPositionEtudiant(etudiant) + deplacement);
											
									Case cours = jeu.getCase(etudiant, jeu, plateau);
											
									if(jeu.getAchetable(cours) && jeu.getProprietaire(cours) == null 
											&& jeu.getEcts(etudiant) >= jeu.getPrixAchat(cours)){
										affiche(jeu, "La case coute " + jeu.getPrixAchat(cours) + " ects.");
										affiche(jeu, "La case rapporte " + jeu.getPrixLoyer(cours) + " ects.");
										affiche(jeu, "Il vous reste " + jeu.getEcts(etudiant) +" ects.");
										affiche(jeu, "Acheter la case : Oui - Non");
												
										boolean	formatEntre = true;
										while(formatEntre){
											String achat = sc.nextLine();
											switch(achat){
												case "Oui" :
												case "oui" :
													controller.setEcts(etudiant, -jeu.getPrixAchat(cours));
													jeu.setProprietaire(etudiant, cours);
													affiche(jeu, "Félicitation vous venez de réussir " + jeu.getNomCase(cours));
													formatEntre = false;
													break;
												
												case "Non" : 
												case "non" :
													formatEntre = false;
													affiche(jeu, "Dommage on se revoit en août !");
													break;
												default :
													affiche(jeu, "Acheter la case : Oui - Non");
											}
										}
												
										affiche(jeu, "Il vous reste " + jeu.getEcts(etudiant) + " ects");
										}
										else if(jeu.getAchetable(cours) && jeu.getProprietaire(cours) == null 
												&& jeu.getEcts(etudiant) < jeu.getPrixAchat(cours)){
											affiche(jeu, "Vous n'avez pas assez d'ects pour tenter de passer ce cours");
											affiche(jeu, "Vous avez toujours " + jeu.getEcts(etudiant) + " ects.");
										}
										else if(jeu.getAchetable(cours) && jeu.getProprietaire(cours) == etudiant){
											affiche(jeu, "Vous avez déjà réussi ce cours");
											affiche(jeu, "Vous avez toujours " + jeu.getEcts(etudiant) + " ects.");
										}
										else if(jeu.getAchetable(cours) && jeu.getProprietaire(cours) != null){
											affiche(jeu, "Le cours a déjà été réussi par : " 
													+ jeu.getNomEtudiant(jeu.getProprietaire(cours)) + ".");
											int loyer = jeu.getPrixLoyer(cours);
											controller.setEcts(etudiant, -loyer);
											controller.setEcts(jeu.getProprietaire(cours), loyer);
											affiche(jeu, "Vous devez lui payer : " + loyer + " ects.");
											affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
										}
										else {
											int position = jeu.getPositionCase(cours);
											switch(position){
											case 0 : 
												controller.setEcts(etudiant, cours.getPrixLoyer());
												affiche(jeu, "Vous venez de recevoir " + jeu.getPrixLoyer(cours) 
													+ "ects, vous avez maintenant " 
													+ jeu.getEcts(etudiant) + " ects.");
												break;
											case 2 :
												controller.setEcts(etudiant, -(cours.getPrixLoyer() * deplacement));
												affiche(jeu, "Interro surprise, vous ratez " + jeu.getPrixLoyer(cours) * deplacement + " ects.");
												affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 4 :
												controller.setEcts(etudiant, -(cours.getPrixLoyer()));
												affiche(jeu, "Vous arrivez en retard à l'examen, vous ratez " 
														+ jeu.getPrixLoyer(cours) + " ects.");
												affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 7 :
												controller.setEcts(etudiant, deplacement);
												affiche(jeu, "Félicitation vous avez " + deplacement + " ects en plus.");
												affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 10 :
												affiche(jeu, "Vous visitez la prison.");
												affiche(jeu, "Vous avez toujours " + etudiant.getEcts() + " ects.");
												break;
											case 17 :
												controller.setEcts(etudiant, -(cours.getPrixLoyer() * deplacement));
												affiche(jeu, "Interro surprise, vous ratez " + jeu.getPrixLoyer(cours) * deplacement + " ects.");
												affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 20 :
												affiche(jeu, "Félicitation vous avez trouver une place de parking "
														+ "gratuit autour de l'ephec.");
												affiche(jeu, "Vous avez toujours " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 22 :
												controller.setEcts(etudiant, deplacement);
												affiche(jeu, "Félicitation vous avez " + deplacement + " ects en plus.");
												affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 30 :
												controller.setPositionEtudiant(etudiant, 10);
												controller.setEtatPrison(etudiant, 2);
												affiche(jeu, "Aller directement en prison sans passer par la case départ,"
														+ " vous resterez emprisonner 2 tours.");
												affiche(jeu, "Vous avez toujours " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 33 :
												controller.setEcts(etudiant, -(cours.getPrixLoyer() * deplacement));
												affiche(jeu, "Interro surprise, vous ratez " + jeu.getPrixLoyer(cours) * deplacement + " ects.");
												affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 36 :
												controller.setEcts(etudiant, deplacement);
												affiche(jeu, "Félicitation vous avez " + deplacement + " ects en plus.");
												affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
												break;
											case 38 :
												controller.setEcts(etudiant, -(cours.getPrixLoyer()));
												affiche(jeu, "Vous arrivez en retard à l'examen, vous ratez " 
														+ jeu.getPrixLoyer(cours) + " ects.");
												affiche(jeu, "Vous avez maintenant " + jeu.getEcts(etudiant) + " ects.");
												break;
											default :
											}
										}
									}
								}
								else if(jeu.getEtatJeu(etudiant) && jeu.getEtatPrison(etudiant) != 0){
									affiche(jeu, "============================================"
											+ "========================================");
									affiche(jeu, "Etudiant : " + jeu.getNomEtudiant(etudiant));
									affiche(jeu, "Vous êtes en prison pour encore " + jeu.getEtatPrison(etudiant) + " tour(s).");
									controller.setEtatPrison(etudiant, jeu.getEtatPrison(etudiant)-1);
								}
								else if(jeu.getEtatJeu(etudiant) == false){
									affiche(jeu, "============================================"
											+ "========================================");
									affiche(jeu, "L'étudiant " + jeu.getNomEtudiant(etudiant) 
										+ " a déjà été éliminé précédemment");
									jeu.finDuJeu(etudiant); // si jamais il y avait eu un bug prècèdemment
								}
								else ;
							}
							catch(InputMismatchException e){
							affiche(jeu, "Format d'input incorrect error1.");
							}
					}
				}
		}
	}
}
