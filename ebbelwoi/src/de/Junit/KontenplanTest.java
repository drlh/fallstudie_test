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
	System.out.println(b);
    }

}
