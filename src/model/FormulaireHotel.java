package model;

public class FormulaireHotel extends Formulaire{
	private int nbLitsSimple;
	private int nbLitDouble;
	
	public FormulaireHotel(int jour, int mois, int nbLitsSimple, int nbLitDouble) {
		super(jour, mois);
		this.nbLitsSimple = nbLitsSimple;
		this.nbLitDouble = nbLitDouble;
	}

	@Override
	public int getIdentificationEntite() {
		return IdentificationEntite;
	}

	@Override
	public void setIdentificationEntite(int indentificationEntite) {
		this.IdentificationEntite = indentificationEntite;
	}

	public int getNbLitsSimple() {
		return nbLitsSimple;
	}

	public int getNbLitDouble() {
		return nbLitDouble;
	}
		
}
