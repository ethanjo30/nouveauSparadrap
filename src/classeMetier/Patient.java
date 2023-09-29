package classeMetier;

import java.awt.Component;
import java.time.LocalDate;
import java.util.Date;

public class Patient extends Personne {
	
	private LocalDate dateNaisssancePat;
	private String numSecuSocial;

	public Patient( String nomPersonne, String prenomPersonne,Adresse adresse, int telPersonne, String emailPersonne,
			LocalDate dateNaisssancePat, String numSecuSocial) {
		super( nomPersonne, prenomPersonne,adresse, telPersonne, emailPersonne);
		this.dateNaisssancePat = dateNaisssancePat;
		this.numSecuSocial = numSecuSocial;
	}

	public LocalDate getDateNaisssancePat() {
		return dateNaisssancePat;
	}

	public void setDateNaisssancePat(LocalDate dateNaisssancePat) {
		this.dateNaisssancePat = dateNaisssancePat;
	}

	public String getNumSecuSocial() {
		return numSecuSocial;
	}

	public void setNumSecuSocial(String numSecuSocial) {
		this.numSecuSocial = numSecuSocial;
	}	
}
