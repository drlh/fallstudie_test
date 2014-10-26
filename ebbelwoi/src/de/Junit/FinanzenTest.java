package de.Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.spiel.unternehmen.Unternehmen;
import de.spiel.unternehmen.abteilung.Finanzen;

public class FinanzenTest {
	Unternehmen un;
	Finanzen f;

	@Before
	public void setUp() throws Exception {
		un = new Unternehmen();
		f = un.getFinanzen();
	}

	@Test
	public void test() {
		/**
		 * exemplarischer test von Buchungen, bei Fehler: fail
		 */
		try {
			// Darlehen
			f.buchen("BA", "DA", 100000.0);
			// Kauf Maschine
			f.buchen("MA", "BA", 50000.0);
			// EInkauf RS
			f.buchen("RS", "BA", 1000.0);
			// Darlehen Rückzahlung
			f.buchen("DA", "BA", 5000.0);

			/* ERTRAG */
			// Umsatz
			f.buchen("BA", "EUE", 50000.0);

			/* AUFWAND */
			// Gehalt
			f.buchen("AGE", "BA", 100.0);
			f.buchen("AFA", "MA", 5000.0);

			f.rundeAbrechnen();
		} catch (Exception e) {
			fail();
		}

	}

}
