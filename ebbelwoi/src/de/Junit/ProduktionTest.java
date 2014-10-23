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
		un = new Unternehmen();
		p = un.getProduktion();
		ma = new Azubi();
	}

	@Test
	public void test() throws AssertionError{
		
		ma.upgrade();
		ma.upgrade();
		ma.upgrade();
		p.getMitarbeiterListe().add(ma);
		assertEquals(3, ma.getStufe());

		MaschineM1 m1 = new MaschineM1(ma);

		p.getMaschinenpark().add(m1);

		assertEquals(1,p.getMitarbeiterListe().size());
		System.out.println(p.getMitarbeiterListe());

		Rohstoff r = new Rohstoff(100.0);
		System.out.println(r.toString());

		p.addAuftrag(m1, r);

		p.produzieren();

		System.out.println(p.getLager().toString());
	}

}
