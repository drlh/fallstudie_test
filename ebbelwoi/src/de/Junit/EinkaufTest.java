package de.Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
		e = new Einkauf();

		e1 = new Vertrieb();
		e2 = new Vertrieb();
		e3 = new Vertrieb();
		e4 = new Vertrieb();

	}

	@Test
	public void test() throws AssertionError {

		e.addMitarbeiterO(e1);
		e.addMitarbeiterO(e2);
		e.addMitarbeiterO(e3);
		e.addMitarbeiterO(e4);

		assertEquals(4, e.size());
		System.out.println(e.getMitarbeiterListe().toString());

		e.get(1).upgrade();
		e.get(3).upgrade();

		assertEquals(1, e.get(1).getStufe());
		assertEquals(1, e.get(3).getStufe());
		System.out.println(e.getMitarbeiterListe().toString());

		e.remove(0);

		assertEquals(3, e.size());
		System.out.println(e.getMitarbeiterListe().toString());

		// fail("Not yet implemented");
	}

}
