package de.spiel.finanzen.konto;

public class Ertragskonto extends Konto
{
    public Ertragskonto(String name)
    {
	super(name);
	this.setType(false, false, true);
    }

    public Ertragskonto(String name, double kontostand)
    {
	super(name, kontostand);
	this.setType(false, false, true);
    }
}
