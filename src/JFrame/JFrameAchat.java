package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classeMetier.Medicament;
import classeMetier.Ordonance;
import classeMetier.Patient;
import classeMetier.initlist;
import classeMetier.myException;
import classeMetier.Historique;
import classeMetier.Personne;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JFrameAchat extends JFrame {

	private JPanel contentPane;
	private JTable tableDonnee;
	private JTextField textNomPat;

	/**
	 * Launch the application.
	 */
	public static void start(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAchat frame = new JFrameAchat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameAchat() {
		
		JButton boutSansOrdo = new JButton("Sans Ordonance");
		JButton boutOrdo = new JButton("Avec Ordonance");
		JComboBox listMedicamentDeroulant = new JComboBox();
		JButton boutValider = new JButton("valider");
		JButton boutSupprimer = new JButton("supprimer");
		JButton boutRetour = new JButton("retour");
		JLabel nonPatient = new JLabel("Nom Patient");
		textNomPat = new JTextField();
		tableDonnee = new JTable();
		tableDonnee.setCellSelectionEnabled(true);
		tableDonnee.setColumnSelectionAllowed(true);
		JButton boutValNom = new JButton("valider");
		
		listMedicamentDeroulant.setPopupVisible(false);
		boutValider.setVisible(false);
		boutRetour.setVisible(false);
		boutSupprimer.setVisible(false);
		textNomPat.setVisible(false);
		tableDonnee.setVisible(false);
		nonPatient.setVisible(false);
		boutValNom.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel pannelPageAchat = new JPanel();
		contentPane.add(pannelPageAchat);
		pannelPageAchat.setLayout(null);
		
		tableDonnee.setBounds(258, 56, 584, 218);
		pannelPageAchat.add(tableDonnee);
				
		textNomPat.setBounds(10, 106, 181, 20);
		pannelPageAchat.add(textNomPat);
		textNomPat.setColumns(10);
		
		nonPatient.setBounds(10, 71, 181, 14);
		pannelPageAchat.add(nonPatient);
		
		/**
		 * a resoudre pb de combobox saffiche 2 fois a la selection 
		 * date forma a resoudre
		 */
		
		boutOrdo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boutSansOrdo.setVisible(false);
				nonPatient.setVisible(true);
				textNomPat.setVisible(true);
				boutValNom.setVisible(true);
				
				textNomPat.addContainerListener(new ContainerAdapter() {
					@Override
					public void componentAdded(ContainerEvent e) {
						Scanner scan = new Scanner(System.in);
						String recupNomPat = scan.nextLine();
					}
				});
				
				boutValNom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						boutValider.setVisible(true);
						boutRetour.setVisible(true);
						boutSupprimer.setVisible(true);
						tableDonnee.setVisible(true);
						
						/**
						 * try catch champ nom vide
						 *  patOrdo represesnte que le nom ou nom plus prenom?
						 */
						String recupNomPat = textNomPat.getText();
						try {
							if(recupNomPat.isEmpty()) {
								throw new IllegalArgumentException("Entrer le nom du patient ");
							}
						} catch (Exception Me) {
							JOptionPane.showMessageDialog(pannelPageAchat, Me.getMessage());
						}
						
						
						for(Ordonance patOrdo : initlist.getListordo()) {
							if (patOrdo.getPatOrdo().equals(recupNomPat)) {
								
								DefaultTableModel model = (DefaultTableModel) tableDonnee.getModel();
								
								model.addRow(new Object[] {patOrdo.getDateOrdonance(),patOrdo.getPatOrdo(),patOrdo.getMutOrdo(),
										patOrdo.getMedOrdo(),patOrdo.getMed1(),patOrdo.getMed2(),patOrdo.getMed3(),patOrdo.getMed4()});
								
							}
						}
					}
				});
				
				tableDonnee.setDefaultEditor(Object.class, null);
								tableDonnee.setModel(new DefaultTableModel(
										new Object[][] {
											{"Date","Patient","Mutuelle","Medecin","Mecament"},
										},
										new String[] {
												"Date","Patient","Mutuelle","Medecin","Mecament"
										}
										
										));
			}
		});
		boutOrdo.setBounds(335, 11, 139, 23);
		pannelPageAchat.add(boutOrdo);
		
		boutSansOrdo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boutOrdo.setVisible(false);
				boutValNom.setVisible(false);
				textNomPat.setVisible(true);
				nonPatient.setVisible(true);
				boutRetour.setVisible(true);
				boutSupprimer.setVisible(true);
				boutValider.setVisible(true);
				tableDonnee.setVisible(true);
				
				/**
				 *  Resoudre probleme e double affichage
				 *  et forma date
				 */
				listMedicamentDeroulant.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						for (Medicament med : initlist.getListMedi()) {
							if (med.getNomMedicament().equals(listMedicamentDeroulant.getSelectedItem())) {
								
								DefaultTableModel model = (DefaultTableModel) tableDonnee.getModel();
								
								model.addRow(new Object[] {med.getCategorieMedicament(),med.getNomMedicament(),
										med.getDateService(),med.getQuantitéMedicament(),med.getPrixMedicament()});
							
							}
							}
					}
				});

				listMedicamentDeroulant.setBounds(10, 149, 181, 22);
				pannelPageAchat.add(listMedicamentDeroulant);
				
				for (Medicament Med : initlist.getListMedi()) {
					listMedicamentDeroulant.addItem(Med.getNomMedicament());
					listMedicamentDeroulant.setSelectedIndex(-1);
				}
				
				tableDonnee.setDefaultEditor(Object.class, null);
				tableDonnee.setModel(new DefaultTableModel(
						new Object[][] {
							{"Categorie","Nom","Date service","Quantité en stock","prix ttc"},
						},
						new String[] {
								"Categorie","Nom","Date service","Quantité en stock","prix ttc"	
						}
						
						));
				
			}
		});
		
		boutSansOrdo.setBounds(648, 11, 119, 23);
		pannelPageAchat.add(boutSansOrdo);		
		
		/**
		 * ajouter au clique valider les info de la page dans un historique
		 */
		
		boutValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String recupNomPat = textNomPat.getText();
				try {
					if(recupNomPat.isEmpty()) {
						throw new IllegalArgumentException("Entrer le nom du patient ");
					}
					if(tableDonnee == null) {
						throw new IllegalArgumentException("Veuillez selectionner des medicament");
					}
				} catch (Exception Me) {
					JOptionPane.showMessageDialog(pannelPageAchat, Me.getMessage());
				}
				
				for(Personne pat : initlist.getListpatient()) {
					if ( pat.getNomPersonne().equals(textNomPat)) {
						initlist.getHistoAchat().add(new Historique(pat.identité(), tableDonnee));
						
						JOptionPane.showConfirmDialog(pannelPageAchat,pat.identité() + "\n" + tableDonnee);
						
					}
				}
		
			}
		});
		
		boutSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

		boutValider.setBounds(678, 305, 89, 23);
		pannelPageAchat.add(boutValider);
		
		boutSupprimer.setBounds(505, 305, 89, 23);
		pannelPageAchat.add(boutSupprimer);
		
		boutRetour.setBounds(335, 305, 89, 23);
		pannelPageAchat.add(boutRetour);
		
		boutValNom.setBounds(45, 159, 85, 21);
		pannelPageAchat.add(boutValNom);
		
	}
}
