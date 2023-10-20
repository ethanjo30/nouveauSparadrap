package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import classeMetier.initlist;
import classeMetier.Ordonance;
import classeMetier.Historique;
import classeMetier.Medecin;
import classeMetier.Medicament;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

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
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox choixMedecin = new JComboBox();
		choixMedecin.setBounds(334, 21, 144, 22);
		panel.add(choixMedecin);
		choixMedecin.setVisible(false);
		
		tableHisto = new JTable();
		tableHisto.setEnabled(false);
		tableHisto.setBounds(24, 82, 804, 315);
		panel.add(tableHisto);
		tableHisto.setVisible(false);
		
		JButton boutHistoAchat = new JButton("histirique achat");
		JButton boutHistOrdo = new JButton("historique Ordonance");
		
		JButton bout_retour = new JButton("retour");
		bout_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bout_retour.setBounds(219, 417, 89, 23);
		panel.add(bout_retour);
		
		
		boutHistOrdo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boutHistoAchat.setVisible(false);
				tableHisto.setVisible(true);
				choixMedecin.setVisible(true);
				
				DefaultTableModel model = (DefaultTableModel) tableHisto.getModel();
				model.setRowCount(1);
				
				for (Medecin medList : initlist.getListmed()) {	
					choixMedecin.addItem(medList.identité());
					choixMedecin.setSelectedIndex(-1);
					
				}
				choixMedecin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						model.setRowCount(1);
						
						for (Ordonance or : initlist.getListordo()) {
							if (or.getMedOrdo().identité().equals(choixMedecin.getSelectedItem())){
						
								initlist.getListMediTampon().removeAll(initlist.getListMediTampon());
						
								initlist.getListMediTampon().add(or.getMed1());
								initlist.getListMediTampon().add(or.getMed2());
								initlist.getListMediTampon().add(or.getMed3());
								initlist.getListMediTampon().add(or.getMed4());
							
								TableColumnModel columnModel = tableHisto.getColumnModel();
								columnModel.getColumn(0).setPreferredWidth(100);
								columnModel.getColumn(1).setPreferredWidth(150);	
								columnModel.getColumn(2).setPreferredWidth(580);
							
								model.addRow(new Object[] {or.getDateOrdonance(),or.getPatOrdo().identité(),initlist.listMediString()});
							}
						}
					}
				});
			}
		});
		
		tableHisto.setModel(new DefaultTableModel(
				new Object[][] {
					{"Date","patient","medicament "},
				},

				new String[] {
						"Date", "patient","medicament"
				}

				));
		
		boutHistOrdo.setBounds(595, 21, 168, 23);
		panel.add(boutHistOrdo);
		
		boutHistoAchat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boutHistOrdo.setVisible(false);
				tableHisto.setVisible(true);
				
				for (Historique histo : initlist.getHistoAchat()) {
					
					DefaultTableModel model = (DefaultTableModel) tableHisto.getModel();
					model.addRow(new Object[] {histo.getDte(), histo.getPat(),histo.getListmed()});
				}
			}
		});
		
		boutHistoAchat.setBounds(94, 21, 153, 23);
		panel.add(boutHistoAchat);
		
		
		
		
	}
}
