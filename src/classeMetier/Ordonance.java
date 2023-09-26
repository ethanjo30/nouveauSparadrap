package classeMetier;

import java.text.DateFormat;
import java.util.Date;

public class Ordonance {
	
	private Date dateOrdonance;
	private Patient patOrdo;
	private Mutuelle mutOrdo;
	private Medecin medOrdo;
	private Medicament med1;
	private Medicament med2;
	private Medicament med3;
	private Medicament med4;
	public Ordonance(Date dateOrdonance, Patient patOrdo, Mutuelle mutOrdo, Medecin medOrdo, Medicament med1, Medicament med2,
			Medicament med3, Medicament med4) {
		super();
		this.dateOrdonance = dateOrdonance;
		this.patOrdo = patOrdo;
		this.mutOrdo = mutOrdo;
		this.medOrdo = medOrdo;
		this.med1 = med1;
		this.med2 = med2;
		this.med3 = med3;
		this.med4 = med4;
	}
	public Ordonance(Date dateOrdonance, Patient patOrdo, Mutuelle mutOrdo, Medecin medOrdo, Medicament med1,
			Medicament med2, Medicament med3) {
		super();
		this.dateOrdonance = dateOrdonance;
		this.patOrdo = patOrdo;
		this.mutOrdo = mutOrdo;
		this.medOrdo = medOrdo;
		this.med1 = med1;
		this.med2 = med2;
		this.med3 = med3;
	}
	public Ordonance(Date dateOrdonance, Patient patOrdo, Mutuelle mutOrdo, Medecin medOrdo, Medicament med1,
			Medicament med2) {
		super();
		this.dateOrdonance = dateOrdonance;
		this.patOrdo = patOrdo;
		this.mutOrdo = mutOrdo;
		this.medOrdo = medOrdo;
		this.med1 = med1;
		this.med2 = med2;
	}
	public Ordonance(Date dateOrdonance, Patient patOrdo, Mutuelle mutOrdo, Medecin medOrdo, Medicament med1) {
		super();
		this.dateOrdonance = dateOrdonance;
		this.patOrdo = patOrdo;
		this.mutOrdo = mutOrdo;
		this.medOrdo = medOrdo;
		this.med1 = med1;
	}
	public Date getDateOrdonance() {
		return dateOrdonance;
	}
	public Patient getPatOrdo() {
		return patOrdo;
	}
	public Mutuelle getMutOrdo() {
		return mutOrdo;
	}
	public Medecin getMedOrdo() {
		return medOrdo;
	}
	public Medicament getMed1() {
		return med1;
	}
	public Medicament getMed2() {
		return med2;
	}
	public Medicament getMed3() {
		return med3;
	}
	public Medicament getMed4() {
		return med4;
	}

	
}
