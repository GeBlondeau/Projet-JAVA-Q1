package ephecopoly.test;
import ephecopoly.controller.*;
import ephecopoly.model.*;
import ephecopoly.view.*;

public class JeuxMVC {
	
	public JeuxMVC(){
		// Création du modèle
		Jeux jeu = new Jeux();
		//Création des contrôleurs : Un pour chaque vue
		//Chaque contrôleur doit avoir une référence vers le modèle pour pouvoir le commander
		JeuxController jeuControlConsole = new JeuxController(jeu);
		JeuxController jeuControlGui = new JeuxController(jeu);
		//Création des vues.
		//Chaque vue doit connaître son contrôleur et avoir une référence vers le modèle pour pouvoir l'observer
		JeuxVueConsole console = new JeuxVueConsole(jeu, jeuControlConsole);
		JeuxVueGraphique gui = new JeuxVueGraphique(jeu, jeuControlGui);
		//On donne la référence à la vue pour chaque contrôleur
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
