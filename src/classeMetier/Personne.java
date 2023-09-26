package classeMetier;

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

	public String identité() {
		return nomPersonne +" " +  prenomPersonne;
	}
}
