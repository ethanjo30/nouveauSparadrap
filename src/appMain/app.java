package appMain;

import java.util.Scanner;

import classeMetier.initlist;


public class app{

	public static void start (String[] args){
		initlist.start();
		String saisie;
		
		do {
			
		System.out.println("0.Achat, 1.Historique, 2.Clients");
		
		Scanner scan = new Scanner(System.in);
		int choix = scan.nextInt();
		
		switch (choix) {
		case 0:
			System.out.println("0.Sans ordonance, 1.Avec ordonance,");
			
			Scanner scan2 = new Scanner(System.in);
			int choix2 = scan2.nextInt();
			
				switch (choix) {
			
				case 0:
					app.AchatSansOrdonance();
					break;
				
				case 1: 
					app.AchatAvecOrdonance();
					break;
				
				default:
					break;
				}
				break;
		case 1: 
			System.out.println("0.Achat, 1.Ordonance,");
			
			Scanner scan3 = new Scanner(System.in);
			int choix3 = scan3.nextInt();
			
				switch (choix3) {
			
				case 0:
					app.HistoAchat();;
					break;
				
				case 1: 
					app.HistoOrdo();
					break;				
	
				default:
					break;
				}
				break;
		case 2: 
			System.out.println("0.Detaille, 1.Ajouter, 2.Modifier, 3.Suprimer");
			
			Scanner scan4 = new Scanner(System.in);
			int choix4 = scan4.nextInt();
			
				switch (choix4) {
			
				case 0:
					app.detailclients();
					break;
					
				case 1:
					app.ajouter();
					break;
					
				case 2:
					app.modifier();
					break;
					
				case 3:
					app.supprimer();
					break;
					
				default:
					break;
				}
				break;
		default:
			break;
			}
		
		System.out.println("souhaiter vous continuer ?");						
		Scanner scan4 = new Scanner(System.in);
		saisie = scan4.nextLine();
		
	} while(saisie.equals("oui"));
		
	}	
	
	public static void AchatSansOrdonance() {
		/**
		 * entrer le nom du patient
		 * 
		 */
	}
	
	public static void AchatAvecOrdonance() {
		
	}
	
	public static void HistoAchat() {
		
	}
	
	public static void HistoOrdo() {
		
	}
	
	public static void detailclients() {
		
		
	}
	
	public static void ajouter() {
		
	}
	
	public static void modifier() {
		
	}
	
	public static void supprimer() {
		
	}
}
