package ephecopoly.test;
import ephecopoly.controller.*;
import ephecopoly.model.*;
import ephecopoly.view.*;

public class JeuxMVC {
	
	public JeuxMVC(){
		// Cr�ation du mod�le
		Jeux jeu = new Jeux();
		Etudiant etudiant = new Etudiant(0, 0, 0, null);
		Case cours = new Case(0, 0, etudiant, null, 0, false);
		Plateau plateau = new Plateau();
		//Cr�ation des contr�leurs : Un pour chaque vue
		//Chaque contr�leur doit avoir une r�f�rence vers le mod�le pour pouvoir le commander
		JeuxController jeuControlConsole = new JeuxController(jeu, etudiant, cours, plateau);
		JeuxController jeuControlGui = new JeuxController(jeu, etudiant, cours, plateau);
		//Cr�ation des vues.
		//Chaque vue doit conna�tre son contr�leur et avoir une r�f�rence vers le mod�le pour pouvoir l'observer
		JeuxVueConsole console = new JeuxVueConsole(jeu, jeuControlConsole);
		JeuxVueGraphique gui = new JeuxVueGraphique(jeu, jeuControlGui);
		//On donne la r�f�rence � la vue pour chaque contr�leur
		jeuControlConsole.addView(console);
		jeuControlGui.addView(gui);
	}
	
	public static void main(String args[]) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JeuxMVC();
			}
		});
	}

}
