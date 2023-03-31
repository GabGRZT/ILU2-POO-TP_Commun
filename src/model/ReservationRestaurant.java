package model;

public class ReservationRestaurant extends Reservation {
	private int numService;
	private int numTable;
	
	public ReservationRestaurant(int numService, int numTable, int jour, int mois) {
		super(jour,mois);
		this.numService = numService;
		this.numTable = numTable;
	}
	
	@Override
	public String toString() {
		return "Le"+jour+"/"+mois+": table n°"+numTable+" pour le deuxieme service";
	}
	
}
