package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classeMetier.initlist;
import classeMetier.Ordonance;
import classeMetier.Medecin;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class JFrameHistorique extends JFrame {

	private JPanel contentPane;
	private JTable tableHisto;

	/**
	 * Launch the application.
	 */
	public static void start(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameHistorique frame = new JFrameHistorique();
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
	public JFrameHistorique() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox choixMedecin = new JComboBox();
		choixMedecin.setBounds(218, 49, 144, 22);
		panel.add(choixMedecin);
		choixMedecin.setVisible(false);
		
		tableHisto = new JTable();
		tableHisto.setBounds(24, 100, 525, 140);
		panel.add(tableHisto);
		tableHisto.setVisible(false);
		
		JButton boutHistoAchat = new JButton("histirique achat");
		JButton boutHistOrdo = new JButton("historique Ordonance");
		
		boutHistOrdo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boutHistoAchat.setVisible(false);
				tableHisto.setVisible(true);
				choixMedecin.setVisible(true);
				
				for (Medecin medList : initlist.getListmed()) {	
					choixMedecin.addItem(medList.getNomPersonne());
					choixMedecin.setSelectedIndex(-1);
					
				}
				
				tableHisto.setModel(new DefaultTableModel(
						new Object[][] {
							{"Date","patient","medicament "},
						},
	
						new String[] {
								"Date", "patient","medicament"
						}

						));
				
				for (Ordonance or : initlist.getListordo()) {
					if (or.getMedOrdo().equals(choixMedecin.getSelectedItem())){
						
						initlist.getListMediTampon().add(or.getMed1());
						initlist.getListMediTampon().add(or.getMed2());
						initlist.getListMediTampon().add(or.getMed3());
						initlist.getListMediTampon().add(or.getMed4());
							
							DefaultTableModel model = (DefaultTableModel) tableHisto.getModel();
							model.addRow(new Object[] {or.getDateOrdonance(),or.getPatOrdo().identité(),initlist.listMediString()});
							
							tableHisto.setModel(model);
						
				}
				}
			}
		});
		boutHistOrdo.setBounds(315, 11, 168, 23);
		panel.add(boutHistOrdo);
		
		boutHistoAchat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boutHistOrdo.setVisible(false);
			}
		});
		boutHistoAchat.setBounds(95, 11, 153, 23);
		panel.add(boutHistoAchat);
		
		
	}
}
