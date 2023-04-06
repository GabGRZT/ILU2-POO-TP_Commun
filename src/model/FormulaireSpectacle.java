package model;

public class FormulaireSpectacle extends Formulaire {
	private int numZone;
	
	public FormulaireSpectacle(int jour, int mois, int numZone) {
		super(jour, mois);
		this.numZone = numZone;
	}

	@Override
	public int getIdentificationEntite() {
		return IdentificationEntite;
	}

	@Override
	public void setIdentificationEntite(int indentificationEntite) {
		this.IdentificationEntite = indentificationEntite;
	}
	

	public int getNumZone() {
		return numZone;
	}
	
}
