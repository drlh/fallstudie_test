package de.Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.abteilung.Finanzen;

public class FinanzenTest
{
    Unternehmen un;
    Finanzen f;

    @Before
    public void setUp() throws Exception
    {
	un = new Unternehmen();
	f = un.getFinanzen();
    }

    @Test
    public void test()
    {
	//Darlehen
	f.getKonten().buchen("BA", "DA", 10000.0);
	//EInkauf RS
	f.getKonten().buchen("RS", "BA", 1000.0);
	//RS Verbrauch
	f.getKonten().buchen("ARS", "RS", 10000.0);
	
	f.rundeAbrechnen();
    }

}
