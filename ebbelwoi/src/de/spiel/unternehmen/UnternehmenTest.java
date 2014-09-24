package de.spiel.unternehmen;

import static org.junit.Assert.*;

import org.junit.Test;

import de.spiel.unternehmen.mitarbeiter.*;

public class UnternehmenTest
{

    @Test
    public void test()
    {
	Unternehmen unternehmen = new Unternehmen();
	
	Mitarbeiter m1 = new Vertrieb();
	Mitarbeiter m2 = new Vertrieb();
	Mitarbeiter m3 = new Vertrieb();
	Mitarbeiter m4 = new Azubi();
	
	unternehmen.getEinkauf().addMitarbeiterO(m1);
	unternehmen.getMarketing().addMitarbeiterO(m2);
	unternehmen.getVerkauf().addMitarbeiterO(m3);
	unternehmen.getProduktion().addMitarbeiterO(m4);
	
	System.out.println(unternehmen.getEinkauf().getMitarbeiterListe().toString());
	System.out.println(unternehmen.getMarketing().getMitarbeiterListe().toString());
	System.out.println(unternehmen.getVerkauf().getMitarbeiterListe().toString());
	System.out.println(unternehmen.getProduktion().getMitarbeiterListe().toString());
	
    }

}
