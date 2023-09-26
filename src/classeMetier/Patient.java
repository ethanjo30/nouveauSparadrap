package classeMetier;

import java.util.Date;

public class Patient extends Personne {
	
	private Date dateNaisssancePat;
	private String numSecuSocial;

	public Patient( String nomPersonne, String prenomPersonne,Adresse adresse, int telPersonne, String emailPersonne,
			Date dateNaisssancePat, String numSecuSocial) {
		super( nomPersonne, prenomPersonne,adresse, telPersonne, emailPersonne);
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
