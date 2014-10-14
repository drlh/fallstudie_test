package de.spiel.finanzen.konto;

public class Aktivkonto extends Konto
{
    public Aktivkonto(String name)
    {
	super(name);
	this.setType(true, true, false);
    }
    
    public Aktivkonto(String name, double kontostand)
    {
	super(name, kontostand);
	this.setType(true, true, false);
    }
}
