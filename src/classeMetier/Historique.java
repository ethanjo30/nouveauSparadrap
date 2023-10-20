package classeMetier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Historique {
	
	private String pat;
	private String listmed;
	private Date dte;
	
	public Historique(Date date,String pat, String listmed) {
		super();
		this.dte = date;
		this.pat = pat;
		this.listmed = listmed;
	}

	public String getPat() {
		return pat;
	}

	public String getListmed() {
		return listmed;
	}

	public String getDte() {
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		return df.format(this.dte);
	}

}
