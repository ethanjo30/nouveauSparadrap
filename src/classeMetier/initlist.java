package classeMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class initlist {
	
	static ArrayList<Patient>listpatient= new ArrayList<>();
	static ArrayList<Medecin>listmed= new ArrayList<>();
	static ArrayList<Medicament>ListMedi= new ArrayList<>();
	static ArrayList<Medicament>ListMediTampon= new ArrayList<>();
	static ArrayList<Ordonance>Listordo= new ArrayList<>();
	static ArrayList<Mutuelle>ListMut= new ArrayList<>();
	static ArrayList<Historique>histoAchat= new ArrayList<>();
	
	public static ArrayList<Medecin> getListmed() {
		return listmed;
	}
	public static void setHistoAchat(ArrayList<Historique> histoAchat) {
		initlist.histoAchat = histoAchat;
	}

	public static ArrayList<Historique> getHistoAchat() {
		return histoAchat;
	}

	public static ArrayList<Medicament> getListMedi() {
		return ListMedi;
	}

	public static void setListpatient(ArrayList<Patient> listpatient) {
		initlist.listpatient = listpatient;
	}

	public static ArrayList<Patient> getListpatient() {
		return listpatient;
	}
	
	public static ArrayList<Ordonance> getListordo() {
		return Listordo;
	}

	public static ArrayList<Medicament> getListMediTampon() {
		return ListMediTampon;
	}
	
	public static String listMediString() {
		String medicament="";
		
		if(!getListMediTampon().isEmpty()) {
			for(Medicament med: getListMediTampon()) {
				if (med!=null) {
					medicament += " " + med.getNomMedicament()+ "\n";
				}
				}
		}	
		return medicament;
	}
	
	public static void start() {
		
		Adresse adpat1 = new Adresse(123,"rue de la Fictivité",75000,"Paris");
		Adresse adpat2 = new Adresse(456," avenue de la Fiction",75000,"Paris");
		Adresse adpat3 = new Adresse(10,"chemin des clous",75000,"Paris");
		Adresse adpat4 = new Adresse(12,"rue de la liberté",75000,"Paris");
		Adresse adpat5 = new Adresse(32,"boulevard mozard",75000,"Paris");
		
		Patient pat1 = new Patient("Martin","Pierre",adpat1,603487571,"Martin.Pierre@gmail.com",LocalDate.of(1997,01,01),"197017512348622");		
		Patient pat2 = new Patient("Durand","Marie",adpat2,611824977,"Durant.Marie@gmail.com",LocalDate.of(2000,05,11),"200057533277804");
		Patient pat3 = new Patient("Petit","Jonathan",adpat3,622030849,"Petit.Jonathan@gmail.com",LocalDate.of(1990,01,31),"190017559644898");
		Patient pat4 = new Patient("Duvet","Honorine",adpat4,615084926,"Duvet.Honorine@gmail.com",LocalDate.of(1993,06,27),"293087510237157");
		Patient pat5 = new Patient("Pierrard","Laetitia",adpat5,648596120,"Pierrard.Laetitia@gmail.com",LocalDate.of(1985,11,13),"285117511247862");
		
		listpatient.add(pat1);
		listpatient.add(pat2);
		listpatient.add(pat3);
		listpatient.add(pat4);
		listpatient.add(pat5);
		
		Adresse adMed1 = new Adresse(11,"place de la nation",75011,"Paris");
		Adresse adMed2 = new Adresse(10,"rue anatole de la forge",75017,"Paris");
		Adresse adMed3 = new Adresse(21,"rue faidherbe",5011,"Paris");
		Adresse adMed4 = new Adresse(133,"avenue de suffren",75007,"Paris");
		Adresse adMed5 = new Adresse(59,"rue geoffroy-saint-hilaire",75005,"Paris");
		
		Medecin med1 = new Medecin("Gallet","Anne",adMed1,622487594,"Gallet.Anne@gmail.com","10123456789","endocrinologue");
		Medecin med2 = new Medecin("Malka","Michel",adMed2,628497557,"Malka.Michel@gmail.com","15847754886","pneumologue");
		Medecin med3 = new Medecin("Khebichat","Omar",adMed3,603518774,"Khebichat.Omar@gmail.com","35148774956","generaliste");
		Medecin med4 = new Medecin("Burseaux","Sarah",adMed4,623351554,"Burseaux.Sarah@gmail.com","31547848875","pediatre");
		Medecin med5 = new Medecin("Rabah","Nacera",adMed5,659889589,"Rabah.Nacera@gmail.com","84975989571","cardiologue");
		
		listmed.add(med1);
		listmed.add(med2);
		listmed.add(med3);
		listmed.add(med4);
		listmed.add(med5);
		
		Medicament medi1 = new Medicament("Analgésique ","Analgesiques",15,LocalDate.of(2023,2,01),50);
		Medicament medi2 = new Medicament("Antispasmodiques","Analgesiques",26,LocalDate.of(2020,9,01),36);
		Medicament medi3 = new Medicament("Corticoïdes","Analgesiques",15,LocalDate.of(2021,7,01),23);
		Medicament medi4 = new Medicament("beta-lactamines","Antibiotiques",12,LocalDate.of(2023,2,01),12);
		Medicament medi5 = new Medicament("Polymyxines","Antibiotiques",24,LocalDate.of(2022,6,01),24);
		Medicament medi6 = new Medicament("Tétracyclines","Antibiotiques",30,LocalDate.of(2023,2,01),6);
		Medicament medi7 = new Medicament("Antituberculeux","Antitubertuleux",36,LocalDate.of(2022,12,01),14);
		Medicament medi8 = new Medicament("Antifongiques","Antimycosiques",11,LocalDate.of(2020,9,01),62);
		Medicament medi9 = new Medicament("Bêta-bloquants","Cardiologie",24,LocalDate.of(2022,6,01),24);
		Medicament medi10 = new Medicament("Correcteurs des bradycardies","Cardiologie",15,LocalDate.of(2023,2,01),100);
		Medicament medi11 = new Medicament("Diurétiques","Cardiologie",38,LocalDate.of(2023,8,01),70);
		Medicament medi12 = new Medicament("Antiacnéiques","Dermatologie",52,LocalDate.of(2022,6,01),24);
		Medicament medi13 = new Medicament("Antiseptiques","Dermatologie",26,LocalDate.of(2022,2,01),83);
		Medicament medi14 = new Medicament("Hormones thyroïdiennes","Endocronologie",27,LocalDate.of(2022,6,01),6);
		Medicament medi15 = new Medicament("Androgènes","Endrocrinologie",33,LocalDate.of(2022,2,01),2);
		Medicament medi16 = new Medicament("Antidiarrhéiques","Gastro-enterologie",12,LocalDate.of(2022,6,01),54);
		
		ListMedi.add(medi1);
		ListMedi.add(medi2);
		ListMedi.add(medi3);
		ListMedi.add(medi4);
		ListMedi.add(medi5);
		ListMedi.add(medi6);
		ListMedi.add(medi7);
		ListMedi.add(medi8);
		ListMedi.add(medi9);
		ListMedi.add(medi10);
		ListMedi.add(medi11);
		ListMedi.add(medi12);
		ListMedi.add(medi13);
		ListMedi.add(medi14);
		ListMedi.add(medi15);
		ListMedi.add(medi16);
		
		Adresse adMut1 = new Adresse(1953,"charle le roi",67000, "strasbourg");
		Adresse adMut2 = new Adresse(20,"footix",75000,"paris");
		Adresse adMut3 = new Adresse(975,"baudelmaire",76600,"havre");
		Adresse adMut4 = new Adresse(57,"place michelin",59000,"lille");
		
		Mutuelle mut1 = new Mutuelle ("Axa",adMut1, 619858875,"axa.serviceClients@gmail.com",67,100);
		Mutuelle mut2 = new Mutuelle ("Mgen",adMut2, 600235898,"mgen.serviceClients@gmail.com",75,100);
		Mutuelle mut3 = new Mutuelle ("Maaf",adMut3,698598748,"maaf.serviceClients@gmail.com",76,100);
		Mutuelle mut4 = new Mutuelle ("Alianz",adMut4,612457849,"alianz.serviceClients@gmail.com",67,100);
		
		ListMut.add(mut3);
		ListMut.add(mut4);
		ListMut.add(mut2);
		ListMut.add(mut1);
		
		Ordonance ordo1 = new Ordonance(LocalDate.of(2023,8,22),pat1,mut1,med1,medi14,medi15,medi1);
		Ordonance ordo2 = new Ordonance(LocalDate.of(2023,7,12),pat2,mut3,med1,medi16);
		Ordonance ordo3 = new Ordonance(LocalDate.of(2022,1,03),pat4,mut4, med2,medi5,medi11,medi6);
		Ordonance ordo4 = new Ordonance(LocalDate.of(2023,8,22),pat3,mut1,med2,medi8,medi1);
		Ordonance ordo5 = new Ordonance(LocalDate.of(2023,5,26),pat5, mut2,med3,medi16,medi1);
		Ordonance ordo6 = new Ordonance(LocalDate.of(2023,7,12),pat2,mut3,med3,medi7);
		Ordonance ordo7 = new Ordonance(LocalDate.of(2022,1,03),pat4, mut4, med3,medi7,medi3,medi2,medi12);
		Ordonance ordo8 = new Ordonance(LocalDate.of(2023,8,22),pat5,mut2, med4,medi10);
		Ordonance ordo9 = new Ordonance(LocalDate.of(2023,5,26),pat3, mut1, med4,medi13,medi11,medi9);
		Ordonance ordo10 = new Ordonance(LocalDate.of(2023,5,26),pat1, mut1, med5,medi10,medi4);
		
		Listordo.add(ordo1);
		Listordo.add(ordo2);
		Listordo.add(ordo3);
		Listordo.add(ordo4);
		Listordo.add(ordo5);
		Listordo.add(ordo6);
		Listordo.add(ordo7);
		Listordo.add(ordo8);
		Listordo.add(ordo9);
		Listordo.add(ordo10);
		
		}

}
