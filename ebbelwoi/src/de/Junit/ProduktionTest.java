package de.Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.spiel.basic.Rohstoff;
import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.abteilung.produktion.*;
import de.spiel.unternehmen.maschinen.MaschineM1;
import de.spiel.unternehmen.mitarbeiter.*;

public class ProduktionTest {
	Unternehmen un;
	Produktion p;
	Azubi ma;

	@Before
	public void setUp() {
		/**
		 * Aufbau der Produktion: 
		 * Produktion aus Unternehmen, 
		 * Erzeugung eines Mitarbeiters (Azubi)
		 */
		un = new Unternehmen();
		p = un.getProduktion();
		ma = new Azubi();
	}

	@Test
	public void test() throws AssertionError {
	    	System.out.println("###\t\tProduktion\t\t###");
		/**
		 * Schulung des Azubis, Zuweisung des Azubi zur Produktion, Prüfung 
		 */
		ma.upgrade();
		ma.upgrade();
		ma.upgrade();
		p.getMitarbeiterListe().add(ma);
		assertEquals(3, ma.getStufe());

		/**
		 * Erzeugung einer Maschine, Zuweisung der Maschine zur Produktion, Prüfen
		 */
		MaschineM1 m1 = new MaschineM1(ma);
		p.getMaschinenpark().add(m1);
		assertEquals(1, p.getMitarbeiterListe().size());
		System.out.println("Eingestellte Mitarbeiter:\n"+p.getMitarbeiterListe()+"\n");
		
		/**
		 * Rohstoff erzeugen, Produktionsauftrag hinzufügen mit m1 und Rohstoff, Produktion anlaufen lassen
		 */
		Rohstoff r = new Rohstoff(100.0);
		System.out.println(r.toString()+"\n");
		p.addAuftrag(m1, r);
		p.produzieren();
		System.out.println();
		
		// Ergebnis ausgeben
		System.out.println(p.getLager().toString());
	}

}
