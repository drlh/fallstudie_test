package de.spiel.finanzen.konto;

public class Passivkonto extends Konto
{
    public Passivkonto(String name)
    {
	super(name);
	this.setType(false, true, false);
    }
    
    public Passivkonto(String name, double kontostand)
    {
	super(name, kontostand);
	this.setType(false, true, false);
    }
}
