package model;


public class CentraleReservation <T extends Formulaire> {
	private EntiteReservable [] tabEntite;
	private int nbEntite = 0;
	
	public CentraleReservation(EntiteReservable[] tabEntite, int nbEntite) {
		this.tabEntite = new EntiteReservable[nbEntite];
		this.nbEntite = nbEntite;
	}
	
	public EntiteReservable ajouterEntite(EntiteReservable <T> entite) {
		tabEntite[nbEntite] = entite;
		nbEntite += 1;
		return entite;
	}
	
	public void donnerPossibilites() {
		
	}
	
	public void reserver () {

	}
}
