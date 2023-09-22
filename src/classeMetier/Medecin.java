package classeMetier;

public class Medecin extends Personne {

	private String numAgrement;
	private String spécialite;
	public Medecin(Adresse adresse, String nomPersonne, String prenomPersonne, int telPersonne, String emailPersonne,
			String numAgrement, String spécialite) {
		super(adresse, nomPersonne, prenomPersonne, telPersonne, emailPersonne);
		this.numAgrement = numAgrement;
		this.spécialite = spécialite;
	}

}
