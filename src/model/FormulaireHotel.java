package model;

public class FormulaireHotel extends Formulaire{
	private int nbLitsSimple;
	private int nbLitDouble;
	
	public FormulaireHotel(int jour, int mois, int nbLitsSimple, int nbLitDouble) {
		super(jour, mois);
		this.nbLitsSimple = nbLitsSimple;
		this.nbLitDouble = nbLitDouble;
	}

	public int getNbLitsSimple() {
		return nbLitsSimple;
	}

	public int getNbLitDouble() {
		return nbLitDouble;
	}
		
}
