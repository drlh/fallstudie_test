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

		boolean b = k.buchen("BA", "DA", 100.0);
		k.getAll().get(1).get("BA").kontoAbrechnen();
		
		assertEquals(true, b);
		System.out.println(b);
	}

}
