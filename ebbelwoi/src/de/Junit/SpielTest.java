package de.Junit;

import org.junit.Before;
import org.junit.Test;

import de.spiel.Spiel;
import de.spiel.Spieler;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.maschinen.MaschineM1;
import de.spiel.unternehmen.mitarbeiter.Azubi;
import de.spiel.unternehmen.mitarbeiter.Vertrieb;

public class SpielTest
{
    Spiel s;
    
    Spieler eins;
    Spieler zwei;

    @Before
    public void setUp() throws Exception
    {
	s = new Spiel();
	
	eins = new Spieler("leo");
	zwei = new Spieler("fabian");
	
	s.add(eins, 100000.0);
	s.add(zwei, 100000.0);
	
	System.out.println(s);
    }

    @Test
    public void test()
    {
	s.ersteRunde();
	Spieler aktuellerSpieler = Spiel.getAktuelleRunde().getAktuellerSpieler();
	//leo
	Azubi m11 = new Azubi();
	Maschine ma11 = new MaschineM1(m11);
	
	aktuellerSpieler.getUnternehmen().getProduktion().getMitarbeiterListe().add(m11);
	aktuellerSpieler.getUnternehmen().getProduktion().addMaschine(ma11);
	
	aktuellerSpieler.getUnternehmen().getEinkauf().addMitarbeiter();
	aktuellerSpieler.getUnternehmen().getVerkauf().addMitarbeiter();
	
	aktuellerSpieler.getUnternehmen().getEinkauf().einkaufenRohstoffe(1000);
	
	
	
	
	s.neueRunde();
    }

}
