package ephecopoly.view;
import java.util.Observer;

import ephecopoly.controller.JeuxController;
import ephecopoly.model.Jeux;

public abstract class JeuxVue implements Observer{
	
	protected Jeux model;
	protected JeuxController controller;
	
	JeuxVue(Jeux model, JeuxController controller){
		this.model = model;
		this.controller = controller;
		model.addObserver(this); // Connexion entre la vue et le modèle
	}
	
	public abstract void affiche(String string);
}