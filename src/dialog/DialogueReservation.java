package dialog;

import java.awt.EventQueue;

import presentation.JFrameReservation;

public class DialogueReservation {
	
	private String date;
	private String time;
	private String numPersons;
	private int numTable;
	
	private JFrameReservation presentationReservation;
	
	
	public void initDialog() {
		//Create presentation frame
		presentationReservation = new JFrameReservation();
		//Associate dialogue to presentation
		presentationReservation.setDialogue(this);
		//Initialize and enable presentation frame
		presentationReservation.initPresentation();
		presentationReservation.setVisible(true);
		
	}
	
	
	public void handleDateSelectedEvent(String date) {
		//TODO
		this.date = date;
		presentationReservation.enableTime();
		System.out.println(date);
	}
	
	public void handleTimeSelectedEvent(String time) {
		//TODO
		this.time = time;
		presentationReservation.enableNumofPersons();
		System.out.println(time);
	}
	
	public void handleNumofPersonsSelectedEvent(String numPersons) {
		//TODO
		this.numPersons = numPersons;
		presentationReservation.enableTableMap();
		System.out.println(numPersons);
				
	}
	
	public void handleTableSelectedEvent(int numTable) {
		//TODO
		this.numTable = numTable;
		presentationReservation.enableValidateButton();
		System.out.println(numTable);
		
	}
	
	public void handleCancelEvent() {
		presentationReservation.initPresentation();
	}
	
	public void handleValidateEvent() {
		//Display confirmation window using JOptionPane
		presentationReservation.enableValidationInformation(date, time, numPersons,numTable);
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Create dialogReservation
		DialogueReservation dialogReservation = new DialogueReservation();
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogReservation.initDialog();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
