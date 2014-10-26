package de.Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.abteilung.Einkauf;
import de.spiel.unternehmen.mitarbeiter.Vertrieb;

public class EinkaufTest {
	Einkauf e;
	Vertrieb e1;
	Vertrieb e2;
	Vertrieb e3;
	Vertrieb e4;

	@Before
	public void setUp() {
		/**
		 * Setup der Einkaufsabteilung:
		 * Erzeugung der Abteilung aus Unternehmen,
		 * Erzeugung von Mitarbeitern 
		 */
		Unternehmen un = new Unternehmen();
		e = un.getEinkauf();

		e1 = new Vertrieb();
		e2 = new Vertrieb();
		e3 = new Vertrieb();
		e4 = new Vertrieb();

	}

	@Test
	public void test() throws AssertionError {
		/**
		 * Zuweisung der MItarbeiter zur Abteilung
		 */

		e.addMitarbeiterO(e1);
		e.addMitarbeiterO(e2);
		e.addMitarbeiterO(e3);
		e.addMitarbeiterO(e4);
		
		/**
		 * prüfen der Zuweisung
		 */
		assertEquals(4, e.size());
		System.out.println(e.getMitarbeiterListe().toString());
		
		/**
		 * Schulun der Mitarbeiter
		 */
		e.get(1).upgrade();
		e.get(3).upgrade();
		
		/**
		 * Prüfung der Ergebnisse
		 */
		assertEquals(1, e.get(1).getStufe());
		assertEquals(1, e.get(3).getStufe());
		System.out.println(e.getMitarbeiterListe().toString());
		
		/**
		 * entlassen eines Mitarbeiters
		 */
		e.remove(0);
		
		/**
		 *prüfen der Entlassung
		 */
		assertEquals(3, e.size());
		System.out.println(e.getMitarbeiterListe().toString());

		// fail("Not yet implemented");
	}

}
