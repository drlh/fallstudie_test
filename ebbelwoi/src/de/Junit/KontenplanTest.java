package de.Junit;

import org.junit.Test;

import de.spiel.finanzen.Kontenplan;

public class KontenplanTest
{

    @Test
    public void test()
    {
	Kontenplan k = new Kontenplan();
	
	boolean b = k.buchen("BA", "DA", 100.0);
	k.getAll().get(1).get("BA").kontoAbrechnen();
	System.out.println(b);
    }

}
