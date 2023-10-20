package classeMetier;

import java.awt.Component;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class Patient extends Personne {
	
	private LocalDate dateNaisssancePat;
	private String numSecuSocial;

	public Patient() {};
	
	public Patient( String nomPersonne, String prenomPersonne,Adresse adresse, String telPersonne, String emailPersonne,
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
		String pattern = ("^[12]{1}[0-9]{14}$");
		 if (!Pattern.matches(pattern, numSecuSocial)) {
		      throw new IllegalArgumentException("numero de securite sociale invalide");
		    }
	}
	
}
