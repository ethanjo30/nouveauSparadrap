package classeMetier;

import java.awt.Component;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Personne {

	private String nomPersonne;
	private String prenomPersonne;
	private Adresse adresse;
	private String telPersonne;
	private String emailPersonne;
	
	public Personne() {};
	
	public Personne( String nomPersonne,String prenomPersonne,Adresse adresse, String telPersonne, String emailPersonne) {
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
		String pattern = ("^[a-zA-Z]*$");
		 if (!Pattern.matches(pattern, nomPersonne)) {
		      throw new IllegalArgumentException("Le nom doit être composé uniquement de lettres.");
		    }
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
		String pattern = ("^[a-zA-Z]*$");
		 if (!Pattern.matches(pattern, prenomPersonne)) {
		      throw new IllegalArgumentException("Le prenom doit être composé uniquement de lettres.");
		    }
	}

	public void setTelPersonne(String telPersonne) {
		this.telPersonne = telPersonne;
		String pattern = ("^((06)|(07)|(09)|(03))[1-9][0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}$");
		 if (telPersonne.length()!= 10) {
		      throw new IllegalArgumentException("le telephone est invalide");
		    }
	}

	public void setEmailPersonne(String emailPersonne) {
		try {
			if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", emailPersonne)) {
				throw new IllegalArgumentException("L'adresse mail est invalide.");
			} 
		} catch (Exception Me) {
				
				JOptionPane.showMessageDialog(null , Me.getMessage());
		}
		
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

	public String getTelPersonne() {
		return telPersonne;
	}

	public String getEmailPersonne() {
		return emailPersonne;
	}
}
