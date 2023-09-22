package classeMetier;

public class Mutuelle {
	private String nomMutuelle;
	private Adresse adresse;
	private int telMutuelle;
	private String emailMutuelle;
	private int departementMutuelle;
	private int tauxRembMutuelle;
	
	public Mutuelle(String nomMutuelle, Adresse adresse, int telMutuelle, String emailMutuelle, int departementMutuelle,
			int tauxRembMutuelle) {
		super();
		this.nomMutuelle = nomMutuelle;
		this.adresse = adresse;
		this.telMutuelle = telMutuelle;
		this.emailMutuelle = emailMutuelle;
		this.departementMutuelle = departementMutuelle;
		this.tauxRembMutuelle = tauxRembMutuelle;
	}
	

	
	
}
