package model;

public abstract class EntiteReservable <F extends Formulaire>{
	private CalendrierAnnuel calendrier = new CalendrierAnnuel();;
	private int identification;
	
	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}
	
	public boolean estLibre (int jour, int mois) {
		return calendrier.estLibre(jour, mois);
	}
	
	public abstract boolean compatible();
	
	public abstract Reservation reserver(F formulaire);
}
