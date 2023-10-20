package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import classeMetier.Adresse;
import classeMetier.Patient;
import classeMetier.Personne;

class Test_unitaire {

	@Test
	
	public void testsetterPersonne(){
		
        Personne p = new Personne();
        
        p.setNomPersonne("renard");
        p.setPrenomPersonne("jerome");
        p.setTelPersonne("0254784859");
        p.setEmailPersonne("renard.jerome@gmail.com");
        
        assertEquals("renard", p.getNomPersonne());
        assertEquals("jerome", p.getPrenomPersonne());
        assertEquals("0254784859", p.getTelPersonne());
        assertEquals("renard.jerome@gmail.com", p.getEmailPersonne());
    }
	
	public void testsetterAdresse(){
	
		Adresse a = new Adresse();
    
		a.setNumAdresse("48");
		a.setNomRueAdresse("rue de la liberter");
		a.setCodePostalAdresse("45874");
		a.setVilleAdesse("Nancy");
		
		assertEquals("48", a.getNumAdresse());
    	assertEquals("rue de la liberter", a.getNomRueAdresse());
		assertEquals("45874", a.getCodePostalAdresse());
	    assertEquals("Nancy", a.getVilleAdesse());
	}
	
	public void testsetterPatient() {
		Patient pa = new Patient();
	    
	    pa.setDateNaisssancePat(LocalDate.of(1998,02,25));
	    pa.setNumSecuSocial("125698748596325");
	    
	    assertEquals(LocalDate.of(1998,02,25), pa.getDateNaisssancePat());
	    assertEquals("125698748596325", pa.getNumSecuSocial());
	}
}
