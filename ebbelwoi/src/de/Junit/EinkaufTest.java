package de.Junit;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.abteilung.Einkauf;
import de.spiel.unternehmen.mitarbeiter.Vertrieb;

public class EinkaufTest
{
    Unternehmen un;
    Einkauf e;

    @Before
    public void setUp() throws Exception
    {
	un = new Unternehmen();
	e = un.getEinkauf();

    }

    @Test
    public void test()
    {
	System.out.println("###\t\tEinkauf\t\t###");
	e.addMitarbeiter();
	
	System.out.println(e.getMitarbeiterListe().toString());
	
	e.einkaufenRohstoffe(10000);
	
	System.out.println(e.getLager().getLagerlisteRohstoffe().toString());;
    }

}
