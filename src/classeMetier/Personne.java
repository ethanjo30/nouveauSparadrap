package classeMetier;

public class Personne {

	private Adresse adresse;
	private String nomPersonne;
	private String prenomPersonne;
	private int telPersonne;
	private String emailPersonne;
	
	public Personne(Adresse adresse, String nomPersonne,
			String prenomPersonne, int telPersonne, String emailPersonne) {
		this.adresse = adresse;
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
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
