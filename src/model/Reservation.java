package model;

public abstract class Reservation {
	protected int jour;
	protected int mois;
	
	protected Reservation(int jour, int mois) {
		super();
		this.jour = jour;
		this.mois = mois;
	}

	public String toString() {
		return "";
	}
	
	
	
}
