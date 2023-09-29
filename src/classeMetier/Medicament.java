package classeMetier;

import java.time.LocalDate;
import java.util.Date;

public class Medicament {
	
	private String nomMedicament;
	private String categorieMedicament;
	private int prixMedicament;
	private LocalDate dateService;
	private int quantitéMedicament;
	
	public Medicament(String nomMedicament, String categorieMedicament, int prixMedicament, LocalDate dateService,
			int quantitéMedicament) {
		super();
		this.nomMedicament = nomMedicament;
		this.categorieMedicament = categorieMedicament;
		this.prixMedicament = prixMedicament;
		this.dateService = dateService;
		this.quantitéMedicament = quantitéMedicament;
	}

	public String getNomMedicament() {
		return nomMedicament;
	}

	public String getCategorieMedicament() {
		return categorieMedicament;
	}

	public int getPrixMedicament() {
		return prixMedicament;
	}

	public LocalDate getDateService() {
		return dateService;
	}

	public int getQuantitéMedicament() {
		return quantitéMedicament;
	}

	
	
}
