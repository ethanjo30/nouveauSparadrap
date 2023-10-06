package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import appMain.appSwing;
import classeMetier.Medicament;
import classeMetier.Ordonance;
import classeMetier.Patient;
import classeMetier.initlist;
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
import java.util.ArrayList;
import java.util.Collection;
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
	static ArrayList<Ordonance>Listpatordo= new ArrayList<>();

	/**
	 * demarrage de la page achat
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
	 * creation de la JFrame achat
	 */
	public JFrameAchat() {
		/**
		 * creation de tout les elelent de la frame
		 */
		JButton boutSansOrdo = new JButton("Sans Ordonance");
		JButton boutOrdo = new JButton("Avec Ordonance");
		JComboBox listMedicamentDeroulant = new JComboBox();
		JButton boutValider = new JButton("valider");
		JButton boutSupprimer = new JButton("supprimer");
		JLabel nonPatient = new JLabel("Nom Patient");
		textNomPat = new JTextField();
		tableDonnee = new JTable();
		tableDonnee.setShowVerticalLines(false);
		JButton boutValNom = new JButton("valider");
		/**
		 * rendu de certain element en invisible
		 */
		listMedicamentDeroulant.setPopupVisible(false);
		boutValider.setVisible(false);
		boutSupprimer.setVisible(false);
		textNomPat.setVisible(false);
		tableDonnee.setVisible(false);
		nonPatient.setVisible(false);
		boutValNom.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel pannelPageAchat = new JPanel();
		contentPane.add(pannelPageAchat);
		pannelPageAchat.setLayout(null);
		
		tableDonnee.setBounds(236, 59, 750, 218);
		pannelPageAchat.add(tableDonnee);
				
		textNomPat.setBounds(10, 106, 181, 20);
		pannelPageAchat.add(textNomPat);
		textNomPat.setColumns(10);
		
		/**
		 * action du bouton retour au clique
		 * il ferme la frame ouverte et retourne au menue principal
		 */
		JButton boutRetour = new JButton("retour");
		boutRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		boutRetour.setBounds(152, 305, 128, 23);
		pannelPageAchat.add(boutRetour);
		
		nonPatient.setBounds(10, 71, 181, 14);
		pannelPageAchat.add(nonPatient);
		
		/**
		 * action du bouton 
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
						
						DefaultTableModel model = (DefaultTableModel) tableDonnee.getModel();
						model.setRowCount(1);
						Listpatordo.removeAll(Listpatordo);
						
						boutRetour.setVisible(true);

						String recupNomPat2 = textNomPat.getText();
						String recupNomPat = recupNomPat2;
						
						recupNomPat = recupNomPat.substring(0,1).toUpperCase() + recupNomPat.substring(1);

						try {
							if(recupNomPat.isEmpty()) {
								throw new IllegalArgumentException("Entrer le nom du patient ");
							}
							if(recupNomPat.isBlank() ) {
								throw new IllegalArgumentException("Entrer le nom du patient ");
							}
							int flag = 0;
							
							for(Patient pat : initlist.getListpatient()) {
								if(recupNomPat.equals(pat.getNomPersonne())) {
								flag = 1;
							}}
							
							if(flag==0) {
								throw new IllegalArgumentException("le petient n'est pas enregistrer");
							}
							
						} catch (Exception Me) {
							JOptionPane.showMessageDialog(pannelPageAchat, Me.getMessage());
						}
						
						for(Ordonance patOrdo : initlist.getListordo()) {

							if (patOrdo.getPatOrdo().getNomPersonne().equals(recupNomPat)) {
								Listpatordo.add(patOrdo);
								tableDonnee.setVisible(true);
								boutValider.setVisible(true);
								
								initlist.getListMediTampon().removeAll(initlist.getListMediTampon());
								
								initlist.getListMediTampon().add(patOrdo.getMed1());
								initlist.getListMediTampon().add(patOrdo.getMed2());
								initlist.getListMediTampon().add(patOrdo.getMed3());
								initlist.getListMediTampon().add(patOrdo.getMed4());
								
								
									
								TableColumnModel columnModel = tableDonnee.getColumnModel();
								columnModel.getColumn(0).setPreferredWidth(100);
								columnModel.getColumn(1).setPreferredWidth(70);	
								columnModel.getColumn(2).setPreferredWidth(580);
								
								model.addRow(new Object[] {patOrdo.getDateOrdonance(),patOrdo.getMedOrdo().getNomPersonne(),
										initlist.listMediString()
										});
							}
						}
					}
				});
				
				tableDonnee.setDefaultEditor(Object.class, null);
								tableDonnee.setModel(new DefaultTableModel(
										new Object[][] {
											{"Date","Medecin","Mecament"},
										},
										new String[] {
												"Date","Medecin","Mecament1"
										}
										
										));	
				
				boutValider.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						try {
							if(tableDonnee.getSelectedRow()== -1) {
								throw new IllegalArgumentException("pas d'ordonance selectionner");
							}
						} catch (Exception Me) {
							JOptionPane.showMessageDialog(pannelPageAchat, Me.getMessage());
						}
						
						for(Ordonance patOrd : Listpatordo) {
							Medicament or;
							
							if(patOrd.getDateOrdonance().equals(tableDonnee.getValueAt(tableDonnee.getSelectedRow(),0)) &&
									patOrd.getMedOrdo().getNomPersonne().equals(tableDonnee.getValueAt(tableDonnee.getSelectedRow(),1))){
								
								initlist.getListMediTampon().removeAll(initlist.getListMediTampon());
								
								initlist.getListMediTampon().add(patOrd.getMed1());
								initlist.getListMediTampon().add(patOrd.getMed2());
								initlist.getListMediTampon().add(patOrd.getMed3());
								initlist.getListMediTampon().add(patOrd.getMed4());
								
								int i = JOptionPane.showConfirmDialog(pannelPageAchat,"patient : " + patOrd.getPatOrdo().getNomPersonne()+" "+ 
										patOrd.getPatOrdo().getPrenomPersonne()+"\n"+ "medecin :" + patOrd.getMedOrdo().getNomPersonne()
										+" "+patOrd.getPatOrdo().getNomPersonne() +"\n"+"medicament : " +initlist.listMediString());
								
								if (i == 0) {
									DefaultTableModel model = (DefaultTableModel) tableDonnee.getModel();
									model.setRowCount(1);
									
									textNomPat.setText(null);
								}
							}
						}
					}
				});			
			}
		});
		
		boutOrdo.setBounds(335, 11, 155, 23);
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
				 */
				for (Medicament Med : initlist.getListMedi()) {
					listMedicamentDeroulant.addItem(Med.getNomMedicament());
					listMedicamentDeroulant.setSelectedIndex(-1);
				}
				
				listMedicamentDeroulant.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent  e) {
						DefaultTableModel model = (DefaultTableModel) tableDonnee.getModel();
						for (Medicament med : initlist.getListMedi()) {
							
							if (med.getNomMedicament().equals(listMedicamentDeroulant.getSelectedItem())) {
								
								initlist.getListMediTampon().add(med);
								
								model.addRow(new Object[] {med.getCategorieMedicament(),med.getNomMedicament(),
										med.getDateService(),med.getQuantitéMedicament(),med.getPrixMedicament()});
							
							}
						}
					}
				});

				listMedicamentDeroulant.setBounds(10, 149, 181, 22);
				pannelPageAchat.add(listMedicamentDeroulant);
				
				tableDonnee.setDefaultEditor(Object.class, null);
				tableDonnee.setModel(new DefaultTableModel(
						new Object[][] {
							{"Categorie","Nom","Date service","Quantité en stock","prix ttc"},
						},
						new String[] {
								"Categorie","Nom","Date service","Quantité en stock","prix ttc"	
						}
						
						));
				
				boutValider.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
					
						
						String listMed = "";
						String pat = null;
						
						String recupNomPat2 = textNomPat.getText();
						String recupNomPat = recupNomPat2;
						
						recupNomPat = recupNomPat.substring(0,1).toUpperCase() + recupNomPat.substring(1);
						
						try {
							
							int flag = 0;
							for(Patient pat2 : initlist.getListpatient())
								if(recupNomPat.equals(pat2.getNomPersonne())) {
								flag = 1;
							}
							if(flag==0) {
								throw new IllegalArgumentException("Nom du patient incorect");
							}
							if(recupNomPat.isEmpty()) {
								throw new IllegalArgumentException("Entrer le nom du patient");
							}
							if(recupNomPat.isBlank()) {
								throw new IllegalArgumentException("Entrer le nom du patient");
							}
							if(tableDonnee.getRowCount()==-1) {
								throw new IllegalArgumentException("pas de medicament selectionner");
							}else {
								
								for(int i = 0; i < tableDonnee.getRowCount(); i++) {
									listMed = listMed +" "+ (String) tableDonnee.getValueAt(i, 1);
								}
								
								for(Patient patient : initlist.getListpatient()) {
									if (patient.getNomPersonne().equals(recupNomPat)) {
										pat = patient.identité();
								}
							}	
								
								int i=JOptionPane.showConfirmDialog(pannelPageAchat, pat +"\n"+"a acheter"+"\n" + initlist.listMediString());
								
								if (i == 0) {
									DefaultTableModel model = (DefaultTableModel) tableDonnee.getModel();
									model.setRowCount(1);
									textNomPat.setText(null);
									listMedicamentDeroulant.setSelectedIndex(-1);
									initlist.getListMediTampon().removeAll(initlist.getListMediTampon());
								}
							}
						} catch (Exception Me) {
							
							JOptionPane.showMessageDialog(pannelPageAchat, Me.getMessage());
						}
					
					}
				});
				
				boutSupprimer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							if(tableDonnee.getSelectedRow()==-1 ) {
								throw new IllegalArgumentException("Pas de ligne selectionné");
							}
							if(tableDonnee.getRowCount()==1) {
								throw new IllegalArgumentException("le tableau est vide");
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(pannelPageAchat, e2.getMessage());
						}
						
						if(tableDonnee.getSelectedRow()== tableDonnee.getSelectedRow()) {

							((DefaultTableModel) tableDonnee.getModel()).removeRow(tableDonnee.getSelectedRow());

						}
					}
				});
			}
		});
		
		boutSansOrdo.setBounds(648, 11, 144, 23);
		pannelPageAchat.add(boutSansOrdo);

		boutValider.setBounds(678, 305, 89, 23);
		pannelPageAchat.add(boutValider);
		
		boutSupprimer.setBounds(505, 305, 103, 23);
		pannelPageAchat.add(boutSupprimer);
		
		boutValNom.setBounds(45, 159, 85, 21);
		pannelPageAchat.add(boutValNom);
		

		
		
		
	}
}
