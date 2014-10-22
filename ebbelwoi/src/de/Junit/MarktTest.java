package de.Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.spiel.umwelt.*;
import de.spiel.umwelt.absatz.Kunde;
import de.spiel.umwelt.beschaffung.Anbieter;
import de.spiel.unternehmen.Unternehmen;

public class MarktTest {
	Unternehmen un;
	Absatzmarkt am;
	Beschaffungsmarkt bm;
	
	@Before
	public void setUp(){
		un = new Unternehmen();
		am = un.getUmwelt().getAbsatz();
		bm = un.getUmwelt().getBeschaffung();
	}

	@Test
	public void test() throws AssertionError {
		
		Kunde[] k = am.getKundenListe();
		Anbieter[] a = bm.getAnbieterListe();
		assertEquals(3, k.length);
		assertEquals(2, a.length);
	}

}
