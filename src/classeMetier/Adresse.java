package classeMetier;

import java.util.regex.Pattern;

public class Adresse {

	private  String numAdresse;
	private  String nomRueAdresse;
	private  String codePostalAdresse;
	private  String villeAdesse;
	
	public Adresse() {};
	
	public void setNumAdresse(String numAdresse) {
		this.numAdresse = numAdresse;
		String pattern = ("^[1-9]{1,3}[0-9]{0,3}$");
		 if (!Pattern.matches(pattern, numAdresse)) {
		      throw new IllegalArgumentException("numero invalide");
		    }
	}

	public void setNomRueAdresse(String nomRueAdresse) {
		this.nomRueAdresse = nomRueAdresse;
		String pattern = ("^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ\\s]+$");
		 if (!Pattern.matches(pattern, nomRueAdresse)) {
		      throw new IllegalArgumentException("Le nom de rue invalide");
		    }
	}

	public void setCodePostalAdresse(String codePostalAdresse) {
		this.codePostalAdresse = codePostalAdresse;
		String pattern = ("^[0-9]{5}$");
		 if (!Pattern.matches(pattern, codePostalAdresse)) {
		      throw new IllegalArgumentException("code postale invalide");
		    }
	}

	public void setVilleAdesse(String villeAdesse) {
		this.villeAdesse = villeAdesse;
		String pattern = ("^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ\\\\s]+$");
		 if (!Pattern.matches(pattern, villeAdesse)) {
		      throw new IllegalArgumentException("ville invalide");
		    }
	}

	public Adresse(String numAdresse, String nomRueAdresse, String codePostalAdresse, String villeAdesse) {
		super();
		this.numAdresse = numAdresse;
		this.nomRueAdresse = nomRueAdresse;
		this.codePostalAdresse = codePostalAdresse;
		this.villeAdesse = villeAdesse;
	}

	public String getNumAdresse() {
		return numAdresse;
	}

	public String getNomRueAdresse() {
		return nomRueAdresse;
	}

	public String getCodePostalAdresse() {
		return codePostalAdresse;
	}

	public String getVilleAdesse() {
		return villeAdesse;
	}
	
	
}
