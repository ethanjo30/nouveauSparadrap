package classeMetier;

import java.awt.Component;

public class Personne {

	private String nomPersonne;
	private String prenomPersonne;
	private Adresse adresse;
	private int telPersonne;
	private String emailPersonne;
	
	public Personne( String nomPersonne,String prenomPersonne,Adresse adresse, int telPersonne, String emailPersonne) {
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.adresse = adresse;
		this.telPersonne = telPersonne;
		this.emailPersonne = emailPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setTelPersonne(int telPersonne) {
		this.telPersonne = telPersonne;
	}

	public void setEmailPersonne(String emailPersonne) {
		this.emailPersonne = emailPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public String identité() {
		return nomPersonne +" " +  prenomPersonne;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public int getTelPersonne() {
		return telPersonne;
	}

	public String getEmailPersonne() {
		return emailPersonne;
	}
}
