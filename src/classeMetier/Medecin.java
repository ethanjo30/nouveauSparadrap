package classeMetier;

public class Medecin extends Personne {

	private String numAgrement;
	private String spécialite;
	
	public Medecin( String nomPersonne, String prenomPersonne,Adresse adresse, int telPersonne, String emailPersonne,
			String numAgrement, String spécialite) {
		super( nomPersonne, prenomPersonne,adresse, telPersonne, emailPersonne);
		this.numAgrement = numAgrement;
		this.spécialite = spécialite;
	}

}
