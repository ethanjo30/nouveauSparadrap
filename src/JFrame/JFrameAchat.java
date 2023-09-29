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
		JLabel nonPatient = new JLabel("Nom Patient");
		textNomPat = new JTextField();
		tableDonnee = new JTable();
		tableDonnee.setShowVerticalLines(false);
		JButton boutValNom = new JButton("valider");
		
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
						
						if(tableDonnee.getRowCount()>1){
							tableDonnee.remove(tableDonnee);
						}
						
						boutRetour.setVisible(true);

						String recupNomPat = textNomPat.getText();
						try {
							if(recupNomPat.isEmpty()) {
								throw new IllegalArgumentException("Entrer le nom du patient ");
							}
							if(recupNomPat.isBlank() ) {
								throw new IllegalArgumentException("Entrer le nom du patient ");
							}
							int flag = 0;
							for(Patient pat : initlist.getListpatient())
								if(recupNomPat.equals(pat.getNomPersonne())) {
								flag = 1;
							}
							if(flag==0) {
								throw new IllegalArgumentException("le petient n'est pas enregistrer");
							}
							
						} catch (Exception Me) {
							JOptionPane.showMessageDialog(pannelPageAchat, Me.getMessage());
						}
						
						for(Ordonance patOrdo : initlist.getListordo()) {

							if (patOrdo.getPatOrdo().getNomPersonne().equals(recupNomPat)) {
								
								tableDonnee.setVisible(true);
								boutValider.setVisible(true);
								
								initlist.getListMediTampon().removeAll(initlist.getListMediTampon());
								
								initlist.getListMediTampon().add(patOrdo.getMed1());
								initlist.getListMediTampon().add(patOrdo.getMed2());
								initlist.getListMediTampon().add(patOrdo.getMed3());
								initlist.getListMediTampon().add(patOrdo.getMed4());
								
								DefaultTableModel model = (DefaultTableModel) tableDonnee.getModel();
									
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
					}
				});			
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
				
				boutValider.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String listMed = "";
						String pat = null;
						
						String recupNomPat = textNomPat.getText();
						try {
							for(Patient pat2 : initlist.getListpatient()) {
							if(recupNomPat != pat2.getNomPersonne()) {
								throw new IllegalArgumentException("Nom du patient incorect");
							}}
							if(recupNomPat.isEmpty()) {
								throw new IllegalArgumentException("Entrer le nom du patient");
							}
							if(recupNomPat.isBlank()) {
								throw new IllegalArgumentException("Entrer le nom du patient");
							}
							if(tableDonnee.getRowCount()==1) {
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
								
								JOptionPane.showConfirmDialog(pannelPageAchat, pat +"\n"+"a acheter"+"\n" +listMed);
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
		
		boutSansOrdo.setBounds(648, 11, 119, 23);
		pannelPageAchat.add(boutSansOrdo);

		boutValider.setBounds(678, 305, 89, 23);
		pannelPageAchat.add(boutValider);
		
		boutSupprimer.setBounds(505, 305, 103, 23);
		pannelPageAchat.add(boutSupprimer);
		
		boutValNom.setBounds(45, 159, 85, 21);
		pannelPageAchat.add(boutValNom);
		

		
		
		
	}
}
