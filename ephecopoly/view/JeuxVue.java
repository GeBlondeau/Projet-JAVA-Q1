package ephecopoly.view;
import java.util.Observer;

import ephecopoly.controller.JeuxController;
import ephecopoly.model.Jeux;

public abstract class JeuxVue implements Observer{
	
	protected Jeux jeu;
	protected JeuxController controller;
	
	JeuxVue(Jeux jeu, JeuxController controller){
		this.jeu = jeu;
		this.controller = controller;
		jeu.addObserver(this); // Connexion entre la vue et le modèle
	}
	
	public abstract void affiche(Jeux jeu, String string);
}