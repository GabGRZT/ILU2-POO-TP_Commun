package model;

public class FormulaireRestaurant extends Formulaire {
	private int nbPersonne;
	private int numService;
	
	public FormulaireRestaurant(int jour, int mois, int nbPersonne, int numService) {
		super(jour, mois);
		this.nbPersonne = nbPersonne;
		this.numService = numService;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public int getNumService() {
		return numService;
	}
	
	@Override
	public int getIdentificationEntite() {
		return IdentificationEntite;
	}

	@Override
	public void setIdentificationEntite(int indentificationEntite) {
		this.IdentificationEntite = indentificationEntite;
	}
	
}
