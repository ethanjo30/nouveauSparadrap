package classeMetier;

import java.util.Date;

public class Patient extends Personne {
	
	private Date dateNaisssancePat;
	private String numSecuSocial;

	public Patient(Adresse adresse, String nomPersonne, String prenomPersonne, int telPersonne, String emailPersonne,
			Date dateNaisssancePat, String numSecuSocial) {
		super(adresse, nomPersonne, prenomPersonne, telPersonne, emailPersonne);
		this.dateNaisssancePat = dateNaisssancePat;
		this.numSecuSocial = numSecuSocial;
	}

	public Date getDateNaisssancePat() {
		return dateNaisssancePat;
	}

	public void setDateNaisssancePat(Date dateNaisssancePat) {
		this.dateNaisssancePat = dateNaisssancePat;
	}

	public String getNumSecuSocial() {
		return numSecuSocial;
	}

	public void setNumSecuSocial(String numSecuSocial) {
		this.numSecuSocial = numSecuSocial;
	}

	
}
