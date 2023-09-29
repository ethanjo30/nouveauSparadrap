package classeMetier;

public class Adresse {

	private  int numAdresse;
	private  String nomRueAdresse;
	private  int codePostalAdresse;
	private  String villeAdesse;
	
	public Adresse(int numAdresse, String nomRueAdresse, int codePostalAdresse, String villeAdesse) {
		super();
		this.numAdresse = numAdresse;
		this.nomRueAdresse = nomRueAdresse;
		this.codePostalAdresse = codePostalAdresse;
		this.villeAdesse = villeAdesse;
	}

	public int getNumAdresse() {
		return numAdresse;
	}

	public String getNomRueAdresse() {
		return nomRueAdresse;
	}

	public int getCodePostalAdresse() {
		return codePostalAdresse;
	}

	public String getVilleAdesse() {
		return villeAdesse;
	}
	
	
}
