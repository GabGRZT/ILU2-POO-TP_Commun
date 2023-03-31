package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import dialog.DialogueReservation;


public class JFrameReservation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelDateTime;
	private JLabel lblChooseDate;
	private JLabel lblChooseTime;
	private JPanel panelNumofPersons;
	private JLabel lblNumofPersons;
	private DatePicker datePicker;
	private JPanel panelTable;
	private JLabel lblTableMap;
	private JButton btnValidate;
	private JPanel panelConfirmCancel;
	private DialogueReservation dialogueReservation;
	private JComboBox comboBoxChoixHeures;
	private JComboBox comboBoxNumOfPersons;
	private JLabel lblNewLabel;
	private JList listTables;


	/**
	 * Create the frame.
	 */
	public JFrameReservation() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		setTitle("R\u00E9servez une table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panelDateTime = new JPanel();
		
		panelNumofPersons = new JPanel();
		
		panelTable = new JPanel();
		
		panelConfirmCancel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelConfirmCancel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelTable, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelNumofPersons, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panelDateTime, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 459, Short.MAX_VALUE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelDateTime, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelNumofPersons, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelConfirmCancel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		lblTableMap = new JLabel("");
		lblTableMap.setIcon(new ImageIcon(JFrameReservation.class.getResource("/resources/Plan_tables.JPG")));
		
		lblNewLabel = new JLabel("3. Choissisez votre table");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		listTables = new JList();
		listTables.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				dialogueReservation.handleTableSelectedEvent(listTables.getSelectedIndex()+1);
			}
		});
		listTables.setEnabled(false);
		listTables.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		listTables.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listTables.setModel(new AbstractListModel() {
			String[] values = new String[] {"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GroupLayout gl_panelTable = new GroupLayout(panelTable);
		gl_panelTable.setHorizontalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTable.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTable.createSequentialGroup()
							.addComponent(lblTableMap, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(listTables, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(24))
						.addGroup(gl_panelTable.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addContainerGap(278, Short.MAX_VALUE))))
		);
		gl_panelTable.setVerticalGroup(
			gl_panelTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTable.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_panelTable.createParallelGroup(Alignment.LEADING)
						.addComponent(listTables, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTableMap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelTable.setLayout(gl_panelTable);
		
		btnValidate = new JButton("Valider");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogueReservation.handleValidateEvent();
			}
		});
		btnValidate.setEnabled(false);
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogueReservation.handleCancelEvent();
			}
		});
		GroupLayout gl_panelConfirmCancel = new GroupLayout(panelConfirmCancel);
		gl_panelConfirmCancel.setHorizontalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(279, Short.MAX_VALUE)
					.addComponent(btnValidate)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancel)
					.addContainerGap())
		);
		gl_panelConfirmCancel.setVerticalGroup(
			gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelConfirmCancel.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_panelConfirmCancel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnCancel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnValidate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelConfirmCancel.setLayout(gl_panelConfirmCancel);
		
		lblNumofPersons = new JLabel("2. Indiquez le nombre de personnes");
		lblNumofPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		comboBoxNumOfPersons = new JComboBox();
		comboBoxNumOfPersons.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				dialogueReservation.handleNumofPersonsSelectedEvent(e.getItem().toString());
			}
		});
		comboBoxNumOfPersons.setEnabled(false);
		comboBoxNumOfPersons.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8"}));
		GroupLayout gl_panelNumofPersons = new GroupLayout(panelNumofPersons);
		gl_panelNumofPersons.setHorizontalGroup(
			gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumofPersons.createSequentialGroup()
					.addGroup(gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumofPersons.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNumofPersons, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelNumofPersons.createSequentialGroup()
							.addGap(80)
							.addComponent(comboBoxNumOfPersons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_panelNumofPersons.setVerticalGroup(
			gl_panelNumofPersons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumofPersons.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNumofPersons, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBoxNumOfPersons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		panelNumofPersons.setLayout(gl_panelNumofPersons);
		
		lblChooseDate = new JLabel("1. Choisissez la date");
		lblChooseDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblChooseTime = new JLabel("et l'heure");
		lblChooseTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		datePicker = new DatePicker();
		datePicker.getComponentDateTextField().setHorizontalAlignment(SwingConstants.LEFT);
		datePicker.addDateChangeListener(new DateChangeListener() {
			public void dateChanged(DateChangeEvent date) {
				do_datePicker_dateChanged(date);
			}
		});
		
		comboBoxChoixHeures = new JComboBox();
		comboBoxChoixHeures.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				dialogueReservation.handleTimeSelectedEvent(e.getItem().toString());
			}
		});
		comboBoxChoixHeures.setEnabled(false);
		comboBoxChoixHeures.setModel(new DefaultComboBoxModel(new String[] {"12h00", "12h30", "13h00", "19h30", "20h00", "20h30"}));
		comboBoxChoixHeures.setToolTipText("Choisissez l'heure");
		GroupLayout gl_panelDateTime = new GroupLayout(panelDateTime);
		gl_panelDateTime.setHorizontalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelDateTime.createSequentialGroup()
									.addGap(148)
									.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelDateTime.createSequentialGroup()
							.addGap(103)
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxChoixHeures, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addGap(85))
		);
		gl_panelDateTime.setVerticalGroup(
			gl_panelDateTime.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDateTime.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChooseDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseTime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panelDateTime.createParallelGroup(Alignment.BASELINE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxChoixHeures, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3))
		);
		panelDateTime.setLayout(gl_panelDateTime);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public void initPresentation() {
		lblChooseDate.setEnabled(true);
		datePicker.setEnabled(true);
		lblChooseTime.setEnabled(false);
		
		lblNumofPersons.setEnabled(false);
		lblNewLabel.setEnabled(false);
		comboBoxChoixHeures.setEnabled(false);
		comboBoxNumOfPersons.setEnabled(false);
		
		lblTableMap.setEnabled(false);
		
		btnValidate.setEnabled(false);
		listTables.setEnabled(false);
		
		System.out.println("InitPresentation done");
	}
	
	public void enableTime() {
		lblChooseTime.setEnabled(true);
		comboBoxChoixHeures.setEnabled(true);
	}
	
	public void enableNumofPersons() {
		lblNumofPersons.setEnabled(true);
		comboBoxNumOfPersons.setEnabled(true);
		
	}
	
	public void enableTableMap() {
		lblNewLabel.setEnabled(true);
		lblTableMap.setEnabled(true);
		listTables.setEnabled(true);
	}
	
	public void enableValidateButton() {
		btnValidate.setEnabled(true);
	}
	
	public void enableValidationInformation(String date, String time, String numPersons, int numTable) {
		String responseMsg = "Reservation confirmee le " + date + " a " + time +
				" pour " + numPersons + " personnes a la table " + numTable + ".";
		int response = JOptionPane.showConfirmDialog(contentPane,responseMsg, "Confirmation de reservation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
	}
	
	
//Record reference to Dialogue
	
	public void setDialogue(DialogueReservation dialogReservation) {
		dialogueReservation = dialogReservation;
	}
	
	protected void do_datePicker_dateChanged(DateChangeEvent date) {
		//TODO
		LocalDate newDate = date.getNewDate();
		String dateFormatted = newDate.getDayOfMonth() + "/" + newDate.getMonthValue() + "/" + newDate.getYear();
		dialogueReservation.handleDateSelectedEvent(dateFormatted);
	}
}
