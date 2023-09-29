package appMain;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JFrame.JFrameAchat;
import JFrame.JFrameClient;
import JFrame.JFrameHistorique;
import classeMetier.initlist;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class appSwing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		initlist.start();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appSwing frame = new appSwing();
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
	public appSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_menuPrincipal = new JPanel();
		contentPane.add(panel_menuPrincipal, BorderLayout.NORTH);
		
		JComboBox menuPrincipal = new JComboBox<String>(new String[] {"Achat", "Historique",
				"Client"}); // pas oublier histo achat et ordo
		menuPrincipal.setSelectedIndex(-1);
		menuPrincipal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		
				switch (menuPrincipal.getSelectedIndex()) {
				
				case 0: 
					JFrameAchat.start(null);
					menuPrincipal.setSelectedIndex(-1);
					break;
				case 1:
					JFrameHistorique.main(null);
					menuPrincipal.setSelectedIndex(-1);
					break;
					
				case 2:
					JFrameClient.start(null);
					menuPrincipal.setSelectedIndex(-1);
					break;
					
				default:
					break;
					
				}
			}
		});
		
		panel_menuPrincipal.add(menuPrincipal);
	}

}
