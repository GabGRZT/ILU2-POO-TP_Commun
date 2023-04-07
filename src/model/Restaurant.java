package model;

public class Restaurant {
	private CentraleReservation<EntiteReservable<FormulaireRestaurant>, FormulaireRestaurant> centrale = new CentraleReservation<EntiteReservable<FormulaireRestaurant>, FormulaireRestaurant>(new EntiteReservable[20]);
	private CalendrierAnnuel calendrierAnnuel;
	
	private class Table extends EntiteReservable<FormulaireRestaurant>{
		private int nbChaises;
		
		public Table(int nbChaises) {
			this.nbChaises = nbChaises;
		}
		
		public ReservationRestaurant reserver(FormulaireRestaurant formulaireRestaurant) {
			int jour = formulaireRestaurant.getJour();
			int mois = formulaireRestaurant.getMois();
			int service = formulaireRestaurant.getNumService();
			int id = formulaireRestaurant.getIdentificationEntite();
			if(compatible(formulaireRestaurant)) {
				if(formulaireRestaurant.getNumService() == 1) {
					calendrierAnnuel.reserver(jour, mois);
				}else {
					calendrierAnnuel.reserver(jour, mois);
				}
				ReservationRestaurant reserve = new ReservationRestaurant(jour, mois, service, id);
				return reserve;
			}else return null;
		}
		
		public boolean TableLibre(FormulaireRestaurant formulaireRestaurant) {
			if(formulaireRestaurant.getNumService() == 1) {
				int jour = formulaireRestaurant.getJour();
				int mois = formulaireRestaurant.getMois();
				return calendrierAnnuel.estLibre(jour, mois);
			}else {
				int jour = formulaireRestaurant.getJour();
				int mois = formulaireRestaurant.getMois();
				return calendrierAnnuel.estLibre(jour, mois);
			}
		}
		
		public boolean compatible(FormulaireRestaurant formulaireRestaurant) {
			int nbPersonne = formulaireRestaurant.getNbPersonne();
			boolean chaisePers = (nbChaises == nbPersonne) || (nbChaises+1 == nbPersonne);
			boolean tableLibre = TableLibre(formulaireRestaurant);
			return chaisePers && tableLibre;
		}
	}
	
	
	public void ajouterTable(int nbChaise) {
		Table table = new Table(nbChaise);
		centrale.ajouterEntite(table);
	}
	
	public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
		return centrale.donnerPossibilites(formulaire);
	}
	
	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		return centrale.reserver(numEntite, formulaire);
	}
}