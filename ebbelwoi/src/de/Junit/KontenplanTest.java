package de.Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.spiel.finanzen.Kontenplan;

public class KontenplanTest {
	Kontenplan k;

	@Before
	public void setUp() {
		k = new Kontenplan();
	}

	@Test
	public void test() throws AssertionError{
	    	System.out.println("###\t\tKontenplan Test\t\t###");
		/**
		 * exemplarisch eDruchführung iener einzelnen Buchung und Prüfung des Ergebnisses
		 */
		boolean b = k.buchen("BA", "DA", 100.0);
		k.getAll().get(1).get("BA").kontoAbrechnen();
		k.getAll().get(3).get("DA").kontoAbrechnen();
		
		assertEquals(true, b);
		System.out.println("Erfolgreich?:" + b+"\n");
		
		System.out.println(k.getAll().get(1).get("BA").toString()+"\n");
		System.out.println(k.getAll().get(3).get("DA").toString());
	}

}
