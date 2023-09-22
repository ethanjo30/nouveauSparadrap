package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classeMetier.Medicament;
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
	private JTable tableFactur;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel pannelPageAchat = new JPanel();
		contentPane.add(pannelPageAchat);
		pannelPageAchat.setLayout(null);
		
		tableFactur = new JTable();
		tableFactur.setBounds(258, 56, 584, 218);
		pannelPageAchat.add(tableFactur);
		
		textNomPat = new JTextField();
		textNomPat.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				Scanner scan = new Scanner(System.in);
				String nomPat = scan.nextLine();
			}
		});
		textNomPat.setBounds(10, 106, 181, 20);
		pannelPageAchat.add(textNomPat);
		textNomPat.setColumns(10);
		
		
		JLabel nonPatient = new JLabel("Nom Patient");
		nonPatient.setBounds(10, 71, 181, 14);
		pannelPageAchat.add(nonPatient);
		
		JComboBox listMedicamentDeroulant = new JComboBox();
		listMedicamentDeroulant.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for (Medicament med : initlist.getListMedi()) {
					if (med.getNomMedicament().equals(listMedicamentDeroulant.getSelectedItem())) {
						
						DefaultTableModel model = (DefaultTableModel) tableFactur.getModel();
						
						model.addRow(new Object[] {med.getCategorieMedicament(),med.getNomMedicament(),
								med.getDateService(),med.getQuantitéMedicament(),med.getPrixMedicament()});
					
					}
					}
			}
		});

		listMedicamentDeroulant.setBounds(10, 149, 181, 22);
		pannelPageAchat.add(listMedicamentDeroulant);
		
		
		JButton boutOrdo = new JButton("Avec Ordonance");
		boutOrdo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		boutOrdo.setBounds(335, 11, 139, 23);
		pannelPageAchat.add(boutOrdo);
		
		JButton boutSansOrdo = new JButton("Sans Ordonance");
		boutSansOrdo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boutOrdo.setVisible(false);
				
				for (Medicament Med : initlist.getListMedi()) {
					listMedicamentDeroulant.addItem(Med.getNomMedicament());
					listMedicamentDeroulant.setSelectedIndex(-1);
				}
				
				tableFactur.setDefaultEditor(Object.class, null);
				tableFactur.setModel(new DefaultTableModel(
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
		
		JButton btnNewButton = new JButton("valider");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				for(Personne pat : initlist.getListpatient()) {
					if ( pat.getNomPersonne().equals(textNomPat)) {
						initlist.getHistoAchat().add(new Historique(pat.identité(), tableFactur));
						
						JOptionPane.showConfirmDialog(pannelPageAchat,pat.identité() + "\n" + tableFactur);
						
					}
				}
				
				System.out.println(initlist.getHistoAchat());
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(678, 305, 89, 23);
		pannelPageAchat.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("supprimer");
		btnNewButton_1.setBounds(505, 305, 89, 23);
		pannelPageAchat.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("retour");
		btnNewButton_2.setBounds(335, 305, 89, 23);
		pannelPageAchat.add(btnNewButton_2);
		
	}
}
