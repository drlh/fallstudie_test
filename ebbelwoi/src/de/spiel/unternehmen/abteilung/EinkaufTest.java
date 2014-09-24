package de.spiel.unternehmen.abteilung;

import static org.junit.Assert.*;

import org.junit.Test;

import de.spiel.unternehmen.mitarbeiter.Vertrieb;

public class EinkaufTest
{

    @Test
    public void test()
    {
	Einkauf e = new Einkauf();
	
	Vertrieb e1 = new Vertrieb();
	Vertrieb e2 = new Vertrieb();
	Vertrieb e3 = new Vertrieb();
	Vertrieb e4 = new Vertrieb();
	
	e.addMitarbeiterO(e1);
	e.addMitarbeiterO(e2);
	e.addMitarbeiterO(e3);
	e.addMitarbeiterO(e4);
	
	System.out.println(e.getMitarbeiterListe().toString());

	e.get(1).upgrade();
	e.get(3).upgrade();

	System.out.println(e.getMitarbeiterListe().toString());

	e.remove(0);

	System.out.println(e.getMitarbeiterListe().toString());

	// fail("Not yet implemented");
    }

}
