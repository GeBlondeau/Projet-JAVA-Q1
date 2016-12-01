package Projet;

public class Case {
	
	private int prixAchat;
	private int prixLoyer;
	private Etudiant proprietaire;
	private String nomCase;
	private int positionCase;
	private boolean achetable;
	
	public int getPrixAchat() {
		return prixAchat;
	}
	public int getPrixLoyer() {
		return prixLoyer;
	}
	public Etudiant getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Etudiant proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getNomCase() {
		return nomCase;
	}
	public int getPositionCase() {
		return positionCase;
	}
	public boolean getAchetable() {
		return achetable;
	}

	public Case(int prixAchat, int prixLoyer, Etudiant proprietaire, String nomCase
			, int positionCase, boolean achetable) {
		this.prixAchat = prixAchat;
		this.prixLoyer = prixLoyer;
		this.proprietaire = proprietaire;
		this.nomCase = nomCase;
		this.positionCase = positionCase;
		this.achetable = achetable;
		
	}
	public void affiche(String string){
		System.out.println(string);
	}
	
	public void caseDepart(Etudiant etudiant, Case cours){
		etudiant.setEcts(cours.getPrixLoyer());
		affiche("Vous venez de recevoir 25 ects, vous avez maintenant " 
				+ etudiant.getEcts() + " ects.");
	}
	public void caseInterro(Etudiant etudiant, Case cours, int deplacement){
		int interro = cours.getPrixLoyer() * deplacement;
		etudiant.setEcts(-interro);
		
		affiche("Interro surprise, vous ratez " + interro + " ects.");
		affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
	}
	public void caseExamen(Etudiant etudiant, Case cours){
		int examen = cours.getPrixLoyer();
		etudiant.setEcts(-examen);
		affiche("Vous arrivez en retard à l'examen, vous ratez " 
				+ examen + " ects.");
		affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
	}
	public void caseChance(Etudiant etudiant, int deplacement){
		etudiant.setEcts(deplacement);
		affiche("Félicitation vous avez " + deplacement + " ects en plus.");
		affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
	}
	public void caseMalchance(Etudiant etudiant, int deplacement){
		etudiant.setEcts(-deplacement);
		affiche("Dommage vous avez " + deplacement + " ects en moins.");
		affiche("Vous avez maintenant " + etudiant.getEcts() + " ects.");
	}
	public void caseVisitePrison(Etudiant etudiant){
		affiche("Vous visitez la prison.");
		affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
	}
	public void caseParkingGratuit(Etudiant etudiant){
		affiche("Félicitation vous avez trouver une place de parking "
				+ "gratuit autour de l'ephec.");
		affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
	}
	public void caseAllerEnPrison(Etudiant etudiant){
		etudiant.setPositionJoueur(10);
		etudiant.setEtatPrison(2);
		affiche("Aller directement en prison sans passer par la case départ,"
				+ " vous resterez emprisonner 2 tours.");
		affiche("Vous avez toujours " + etudiant.getEcts() + " ects.");
	}
	
}