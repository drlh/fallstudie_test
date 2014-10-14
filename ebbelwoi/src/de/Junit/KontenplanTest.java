package de.Junit;

import org.junit.Test;

import de.spiel.finanzen.konto.Kontenplan;

public class KontenplanTest
{

    @Test
    public void test()
    {
	Kontenplan k = new Kontenplan();
	
	boolean b = k.buchen("BA", "DA", 1000000.00);
	System.out.println(b);
    }

}
