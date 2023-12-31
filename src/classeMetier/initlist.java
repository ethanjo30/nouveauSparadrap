package classeMetier;

import java.text.SimpleDateFormat;
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

	public static void setHistoAchat(ArrayList<Historique> histoAchat) {
		initlist.histoAchat = histoAchat;
	}

	public static ArrayList<Historique> getHistoAchat() {
		return histoAchat;
	}

	public static ArrayList<Medicament> getListMedi() {
		return ListMedi;
	}

	public static ArrayList<Patient> getListpatient() {
		return listpatient;
	}

	public static void start() {
		
		Adresse adpat1 = new Adresse(123,"rue de la Fictivité",75000,"Paris");
		Adresse adpat2 = new Adresse(456," avenue de la Fiction",75000,"Paris");
		Adresse adpat3 = new Adresse(10,"chemin des clous",75000,"Paris");
		Adresse adpat4 = new Adresse(12,"rue de la liberté",75000,"Paris");
		Adresse adpat5 = new Adresse(32,"boulevard mozard",75000,"Paris");
		
		Patient pat1 = new Patient(adpat1,"Martin","Pierre",603487571,"Martin.Pierre@gmail.com",new Date(01/01/1997),"197017512348622");		
		Patient pat2 = new Patient(adpat2,"Durand","Marie",611824977,"Durant.Marie@gmail.com",new Date(05/12/2000),"200057533277804");
		Patient pat3 = new Patient(adpat3,"Petit","Jonathan",622030849,"Petit.Jonathan@gmail.com",new Date(31/01/1990),"190017559644898");
		Patient pat4 = new Patient(adpat4,"Duvet","Honorine",615084926,"Duvet.Honorine@gmail.com",new Date(27/06/1993),"293087510237157");
		Patient pat5 = new Patient(adpat5,"Pierard","Laetitia",648596120,"Pierrard.Laetitia@gmail.com",new Date(13/11/1985),"285117511247862");
		
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
		
		Medecin med1 = new Medecin(adMed1,"Gallet","Anne",622487594,"Gallet.Anne@gmail.com","10123456789","endocrinologue");
		Medecin med2 = new Medecin(adMed2,"Malka","Michel",628497557,"Malka.Michel@gmail.com","15847754886","pneumologue");
		Medecin med3 = new Medecin(adMed3,"Khebichat","Omar",603518774,"Khebichat.Omar@gmail.com","35148774956","generaliste");
		Medecin med4 = new Medecin(adMed4,"Burseaux","Sarah",623351554,"Burseaux.Sarah@gmail.com","31547848875","pediatre");
		Medecin med5 = new Medecin(adMed5,"Rabah","Nacera",659889589,
				"Rabah.Nacera@gmail.com","84975989571","cardiologue");
		
		listmed.add(med1);
		listmed.add(med2);
		listmed.add(med3);
		listmed.add(med4);
		listmed.add(med5);
		
		Medicament medi1 = new Medicament("Analgésique d'action centrale preponderante","Analgesiques",15,new Date(02/2023),50);
		Medicament medi2 = new Medicament("Antispasmodiques","Analgesiques",26,new Date(9/2020),36);
		Medicament medi3 = new Medicament("Corticoïdes","Analgesiques",15,new Date(07/2021),23);
		Medicament medi4 = new Medicament("beta-lactamines","Antibiotiques",12,new Date(02/2023),12);
		Medicament medi5 = new Medicament("Polymyxines","Antibiotiques",24,new Date(06/2022),24);
		Medicament medi6 = new Medicament("Tétracyclines","Antibiotiques",30,new Date(01/2021),6);
		Medicament medi7 = new Medicament("Antituberculeux","Antitubertuleux",36,new Date(12/2022),14);
		Medicament medi8 = new Medicament("Antifongiques","Antimycosiques",11,new Date(11/2020),62);
		Medicament medi9 = new Medicament("Bêta-bloquants","Cardiologie",24,new Date(8/2023),24);
		Medicament medi10 = new Medicament("Correcteurs des bradycardies","Cardiologie",15,new Date(6/2021),100);
		Medicament medi11 = new Medicament("Diurétiques","Cardiologie",38,new Date(02/2022),70);
		Medicament medi12 = new Medicament("Antiacnéiques","Dermatologie",52,new Date(06/2022),24);
		Medicament medi13 = new Medicament("Antiseptiques","Dermatologie",26,new Date(06/2021),83);
		Medicament medi14 = new Medicament("Hormones thyroïdiennes","Endocronologie",27,new Date(06/2023),6);
		Medicament medi15 = new Medicament("Androgènes","Endrocrinologie",33,new Date(9/2022),2);
		Medicament medi16 = new Medicament("Antidiarrhéiques","Gastro-enterologie",12,new Date(3/2023),54);
		
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
		
		Ordonance ordo1 = new Ordonance(new Date(22/8/23),pat1,mut1,med1,"Hormones", "thyroïdiennes","Androgènes"," ");
		Ordonance ordo2 = new Ordonance(new Date(12/7/23),"Gallet","Anne","Durand","Marie","Antidiarrhéiques"," "," "," ");
		Ordonance ordo3 = new Ordonance(new Date(03/1/22),"Malka","Michel","Duvet","Honorine","Polymyxines","Diurétiques","Tétracyclines"," ");
		Ordonance ordo4 = new Ordonance(new Date(22/8/23),"Malka","Michel","Petit","Jonathan","Antifongiques","Analgésique"," "," ");
		Ordonance ordo5 = new Ordonance(new Date(26/5/23),"Khebichat","Omar","Pierard","Laetitia","Antidiarrhéiques","Analgésique"," "," ");
		Ordonance ordo6 = new Ordonance(new Date(22/8/23),"Khebichat","Omar","Durand","Marie","Analgésique"," "," "," ");
		Ordonance ordo7 = new Ordonance(new Date(22/8/23),"Khebichat","Omar","Duvet","Honorine","Antituberculeux","Corticoïde","Antiacnéiques","Antispasmodiques");
		Ordonance ordo8 = new Ordonance(new Date(22/8/23),"Burseaux","Sarah","Pierard","Laetitia","Antituberculeux"," "," "," ");
		Ordonance ordo9 = new Ordonance(new Date(22/8/23),"Burseaux","Sarah","Petit","Jonathan","Antiseptique","Diurétiques","antibactériens"," ");
		Ordonance ordo10 = new Ordonance(new Date(22/2/23),"Rabah","Nacera","Martin","Pierre","Correcteurs des bradycardies","Bêta-bloquant"," "," ");
		
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
