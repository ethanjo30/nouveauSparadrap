package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import appMain.appSwing;
import classeMetier.Adresse;
import classeMetier.Patient;
import classeMetier.Personne;
import classeMetier.initlist;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameClient extends JFrame {

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textTel;
	private JTextField textNaissance;
	private JTextField textSecu;
	private JTextField textMail;
	private JTextField textNumRue;
	private JTextField textNomRue;
	private JTextField textCP;
	private JTextField textVille;
	
	private Patient patInprogress = null;
	private Adresse adInprogress = null;
	/**
	 * Launch the application.
	 */
	public static void start(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameClient frame = new JFrameClient();
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
	public JFrameClient() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelClient = new JPanel();
		contentPane.add(panelClient);
		panelClient.setLayout(null);
		
		textNom = new JTextField();
		textNom.setBounds(87, 43, 86, 20);
		panelClient.add(textNom);
		textNom.setColumns(10);
		textNom.setVisible(true);
		
		JLabel labNom = new JLabel("Nom");
		labNom.setBounds(22, 46, 27, 14);
		panelClient.add(labNom);
		labNom.setVisible(true);
		
		//lab
		JButton boutValider = new JButton("Valider");
		boutValider.setBounds(335, 306, 89, 23);
		panelClient.add(boutValider);
		boutValider.setVisible(true);
		
		JButton boutModif = new JButton("Modifier");
		boutModif.setBounds(335, 306, 89, 23);
		panelClient.add(boutModif);
		boutModif.setVisible(false);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(300, 43, 86, 20);
		panelClient.add(textPrenom);
		textPrenom.setColumns(10);
		textPrenom.setVisible(true);
		
		JLabel labPrenom = new JLabel("Prenom");
		labPrenom.setBounds(194, 46, 81, 14);
		panelClient.add(labPrenom);
		labPrenom.setVisible(true);
		
		textTel = new JTextField();
		textTel.setBounds(87, 72, 86, 20);
		panelClient.add(textTel);
		textTel.setColumns(10);
		textTel.setVisible(false);
		
		textNaissance = new JTextField();
		textNaissance.setBounds(300, 72, 86, 20);
		panelClient.add(textNaissance);
		textNaissance.setColumns(10);
		textNaissance.setVisible(false);
		
		textSecu = new JTextField();
		textSecu.setBounds(87, 103, 188, 20);
		panelClient.add(textSecu);
		textSecu.setColumns(10);
		textSecu.setVisible(false);
		
		textMail = new JTextField();
		textMail.setBounds(87, 134, 288, 20);
		panelClient.add(textMail);
		textMail.setColumns(10);
		textMail.setVisible(false);
		
		JLabel labTel = new JLabel("Telephone");
		labTel.setBounds(22, 75, 59, 14);
		panelClient.add(labTel);
		labTel.setVisible(false);
		
		JLabel labEmail = new JLabel("e-mail");
		labEmail.setBounds(22, 137, 46, 14);
		panelClient.add(labEmail);
		labEmail.setVisible(false);
		
		JLabel labDateNaissance = new JLabel("date de naissance");
		labDateNaissance.setBounds(194, 75, 134, 14);
		panelClient.add(labDateNaissance);
		labDateNaissance.setVisible(false);
		
		JLabel labSecu = new JLabel("N° secu");
		labSecu.setBounds(22, 106, 55, 14);
		panelClient.add(labSecu);
		labSecu.setVisible(false);
		
		textNumRue = new JTextField();
		textNumRue.setBounds(87, 190, 86, 20);
		panelClient.add(textNumRue);
		textNumRue.setColumns(10);
		textNumRue.setVisible(false);
		
		JLabel labAdresse = new JLabel("Adresse");
		labAdresse.setBounds(72, 165, 86, 14);
		panelClient.add(labAdresse);
		labAdresse.setVisible(false);
		
		JLabel labNumRue = new JLabel("N°");
		labNumRue.setBounds(22, 189, 46, 14);
		panelClient.add(labNumRue);
		labNumRue.setVisible(false);
		
		JLabel labRue = new JLabel("rue");
		labRue.setBounds(22, 224, 46, 14);
		panelClient.add(labRue);
		labRue.setVisible(false);
		
		textNomRue = new JTextField();
		textNomRue.setBounds(87, 221, 218, 20);
		panelClient.add(textNomRue);
		textNomRue.setColumns(10);
		textNomRue.setVisible(false);
		
		JLabel labCodePostal = new JLabel("Code Postal");
		labCodePostal.setBounds(10, 255, 71, 14);
		panelClient.add(labCodePostal);
		labCodePostal.setVisible(false);
		
		textCP = new JTextField();
		textCP.setBounds(87, 252, 86, 20);
		panelClient.add(textCP);
		textCP.setColumns(10);
		textCP.setVisible(false);
		
		JLabel labVille = new JLabel("Ville");
		labVille.setBounds(205, 257, 40, 14);
		panelClient.add(labVille);
		labVille.setVisible(false);
		
		textVille = new JTextField();
		textVille.setBounds(242, 254, 86, 20);
		panelClient.add(textVille);
		textVille.setColumns(10);
		textVille.setVisible(false);
		
		JButton boutRetour = new JButton("retour");
		boutRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton boutNouvPat = new JButton("Nouveau");
		boutNouvPat.setBounds(235, 306, 96, 23);
		panelClient.add(boutNouvPat);
		boutNouvPat.setVisible(false);
		
		boutRetour.setBounds(0, 306, 119, 23);
		panelClient.add(boutRetour);
		
		JLabel labNouvPat = new JLabel("enregistrement du nouveau patient");
		labNouvPat.setBounds(113, 11, 206, 14);
		panelClient.add(labNouvPat);
		labNouvPat.setVisible(false);
		
		
		JButton boutSuprimer = new JButton("Supprimer");
		boutSuprimer.setBounds(122, 306, 110, 23);
		panelClient.add(boutSuprimer);
		boutSuprimer.setVisible(false);
		
		
				boutValider.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						textTel.setVisible(true);
						textNaissance.setVisible(true);
						textSecu.setVisible(true);
						textMail.setVisible(true);
						textNumRue.setVisible(true);
						textNomRue.setVisible(true);
						textCP.setVisible(true);
						textVille.setVisible(true);
						labNom.setVisible(true);
						labPrenom.setVisible(true);
						labTel.setVisible(true);
						labDateNaissance.setVisible(true);
						labSecu.setVisible(true);
						labEmail.setVisible(true);
						labAdresse.setVisible(true);
						labNumRue.setVisible(true);
						labRue.setVisible(true);
						labCodePostal.setVisible(true);
						labVille.setVisible(true);
						boutRetour.setVisible(true);
						boutValider.setVisible(true);
						boutNouvPat.setVisible(false);
						boutSuprimer.setVisible(true);
						boutModif.setVisible(true);
						boutValider.setVisible(false);
						boutNouvPat.setVisible(true);
						
						
						String recupNomPat2 = textNom.getText();
						String recupNomPat = recupNomPat2;
						recupNomPat = recupNomPat.substring(0,1).toUpperCase() + recupNomPat.substring(1);
						
						String recuPrenomPat2 = textNom.getText();
						String recuPrenomPat = textPrenom.getText();
						recuPrenomPat = recuPrenomPat.substring(0,1).toUpperCase() + recuPrenomPat.substring(1);
						
						Personne patientsaisi = new Personne();
						
						try {
							
							patientsaisi.setNomPersonne(recuPrenomPat);
							patientsaisi.setPrenomPersonne(recuPrenomPat);
							
							if(recupNomPat.isBlank()) {
								throw new IllegalArgumentException("veuillez entrer le nom du patient");
							}
							if(recupNomPat.isEmpty()) {
								throw new IllegalArgumentException("veuillez entrer le nom du patient");
							}
							if(recuPrenomPat.isBlank()) {
								throw new IllegalArgumentException("veuillez entrer le prenom du patient");
							}
							if(recuPrenomPat.isEmpty()) {
								throw new IllegalArgumentException("veuillez entrer le prenom du patient");
							}
						} catch (Exception Me) {
							JOptionPane.showMessageDialog(panelClient, Me.getMessage());
						}
						
						textNom.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recupNomPat = scan.nextLine();
							}
						});
						
						textPrenom.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recuPrenomPat = scan.nextLine();
							}
						});
						
						for (Patient pat : initlist.getListpatient()) {
							if(recupNomPat.equals(pat.getNomPersonne())&&(recuPrenomPat.equals(pat.getPrenomPersonne()))){
								
								// sauvegarder le patient
									patInprogress = pat;
									adInprogress = pat.getAdresse();
									
									textTel.setText(pat.getTelPersonne()+"");
									textNaissance.setText(pat.getDateNaisssancePat()+"");
									textSecu.setText(pat.getNumSecuSocial());
									textMail.setText(pat.getEmailPersonne());
									textNumRue.setText(pat.getAdresse().getNumAdresse()+"");
									textNomRue.setText(pat.getAdresse().getNomRueAdresse());
									textCP.setText(pat.getAdresse().getCodePostalAdresse()+"");
									textVille.setText(pat.getAdresse().getVilleAdesse());
							} 
						}
						
					}
				});
				
				boutModif.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						String recupNomPat = textNom.getText();
						String recuPrenomPat = textPrenom.getText();
						
						recupNomPat = recupNomPat.substring(0,1).toUpperCase() + recupNomPat.substring(1);
						recuPrenomPat = recuPrenomPat.substring(0,1).toUpperCase() + recuPrenomPat.substring(1);
						
						String recuNom = textNom.getText();
						String recupPrenom = textPrenom.getText();
						LocalDate recupNaissance = null;
						String recupTel = textTel.getText();
						String recupMail = textMail.getText();
						try {
						String pattern = ("^[0-9]{5}$");
						 if (Pattern.matches(pattern, textNaissance.getText())) {
						      recupNaissance = LocalDate.parse(textNaissance.getText());
						    } 
						}catch (Exception Me) {
						    	throw new IllegalArgumentException("erreur forma date yyyy-mm-dd");
						    }
						String recupSecu = textSecu.getText();
						String recupNumRue = textNumRue.getText();
						String recupNomRue = textNomRue.getText();
						String recupCP = textCP.getText();
						String recupVille = textVille.getText();
						
						
							try {
								patInprogress.setTelPersonne(recupTel);
								patInprogress.setEmailPersonne(recupMail);
								patInprogress.setDateNaisssancePat(recupNaissance);
								patInprogress.setNumSecuSocial(recupSecu);
								adInprogress.setNumAdresse((String) recupNumRue);
								adInprogress.setNomRueAdresse(recupNomRue);
								adInprogress.setCodePostalAdresse((String)recupCP);
								adInprogress.setVilleAdesse(recupVille);
								
								JOptionPane.showMessageDialog(panelClient, "les information ont été mis a jours");
							}catch (Exception ME) {
								JOptionPane.showMessageDialog(panelClient, ME.getMessage());
							}
					}
				});
				
			boutSuprimer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String recupNomPat = textNom.getText();
					String recuPrenomPat = textPrenom.getText();
					
					recupNomPat = recupNomPat.substring(0,1).toUpperCase() + recupNomPat.substring(1);
					
					recuPrenomPat = recuPrenomPat.substring(0,1).toUpperCase() + recuPrenomPat.substring(1);
					
					
					
					for(Patient pat : initlist.getListpatient()) {

							if(recupNomPat.equals(pat.getNomPersonne())&&(recuPrenomPat.equals(pat.getPrenomPersonne()))){
								System.out.println(pat.identité());
								initlist.getListpatient().remove(pat);
								JOptionPane.showMessageDialog(boutSuprimer,"Le patient a bien été supprimer");
							}
							
								
								
						}
				}
			});
			
				boutNouvPat.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						String recupNomPat = textNom.getText();
						String recuPrenomPat = textPrenom.getText();
						
						recupNomPat = recupNomPat.substring(0,1).toUpperCase() + recupNomPat.substring(1);
						recuPrenomPat = recuPrenomPat.substring(0,1).toUpperCase() + recuPrenomPat.substring(1);
						
						LocalDate recupNaissance = null;
						
						textNom.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recuNom = scan.nextLine();
							}
						});
						textPrenom.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recupPrenom = scan.nextLine();
							}
						});
						textTel.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recupTel = scan.nextLine();
							}
						});
						textMail.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recupMail = scan.nextLine();
							}
						});
						textNaissance.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								int recupNaissance = scan.nextInt();
							}
						});
						textSecu.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recupSecu = scan.nextLine();
							}
						});
						textNumRue.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								int recupNumRue = scan.nextInt();
							}
						});
						textNomRue.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recupNomRue = scan.nextLine();
							}
						});
						textCP.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								int recupCP = scan.nextInt();
							}
						});
						textVille.addContainerListener(new ContainerAdapter() {
							@Override
							public void componentAdded(ContainerEvent e) {
								Scanner scan = new Scanner(System.in);
								String recupVille = scan.nextLine();
							}
						});
						
						
						String recuNom = textNom.getText();
						String recupPrenom = textPrenom.getText();
						String recupTel = textTel.getText();
						String recupMail = textMail.getText();
						try {
						String pattern = ("^[0-9]{5}$");
						 if (Pattern.matches(pattern, textNaissance.getText())) {
						      recupNaissance = LocalDate.parse(textNaissance.getText());
						    } 
						}catch (Exception Me) {
						    	throw new IllegalArgumentException("erreur forma date yyyy-mm-dd");
						    }
						String recupSecu = textSecu.getText();
						String recupNumRue = textNumRue.getText();
						String recupNomRue = textNomRue.getText();
						String recupCP = textCP.getText();
						String recupVille = textVille.getText();
						
						
						Adresse adTampon = new Adresse(recupNumRue , recupNomRue , recupCP , recupVille);
						
						for (Patient pat : initlist.getListpatient()) {
							if(recupNomPat != pat.getNomPersonne() | recuPrenomPat != pat.getPrenomPersonne()){
								Patient nouvpat = new Patient();
								Adresse nouvad = new Adresse();
						
						try {
							nouvpat.setTelPersonne(recupTel);
							nouvpat.setEmailPersonne(recupMail);
							nouvpat.setDateNaisssancePat(recupNaissance);
							nouvpat.setNumSecuSocial(recupSecu);
							nouvad.setNumAdresse((String) recupNumRue);
							nouvad.setNomRueAdresse(recupNomRue);
							nouvad.setCodePostalAdresse((String)recupCP);
							nouvad.setVilleAdesse(recupVille);
							
							initlist.getListpatient().add(new Patient(nouvpat.getTelPersonne(),nouvpat.getEmailPersonne(), 
									adInprogress, recupTel, recupMail, recupNaissance, recupSecu));
									
									JOptionPane.showMessageDialog(boutNouvPat,"Le patient a été enregistrer");
							
						}catch (Exception ME) {
							
							JOptionPane.showMessageDialog(boutNouvPat, ME.getMessage());
						}
						
							}}
					}
				});

		}
}
