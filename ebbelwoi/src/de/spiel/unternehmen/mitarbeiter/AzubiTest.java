package de.spiel.unternehmen.mitarbeiter;

import static org.junit.Assert.*;

import org.junit.Test;

public class AzubiTest
{

    @Test
    public void test()
    {
	Azubi a = new Azubi();
	a.upgrade();
	a.upgrade();
	System.out.println(a);
    }

}
