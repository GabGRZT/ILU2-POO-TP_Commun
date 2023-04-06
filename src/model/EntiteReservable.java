package model;

public class EntiteReservable <F extends Formulaire>{
	private String calendrier;
	private int identification;
	
	public EntiteReservable(String calendrier, int identification) {
		super();
		this.calendrier = calendrier;
		this.identification = identification;
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}
	
	public boolean estLibre (F formulaire) {
		return true;
	}
	
	public void compatible() {
		
	}
	
	public void reserver() {
		
	}
}
