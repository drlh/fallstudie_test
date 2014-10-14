package de.spiel.finanzen.konto;

public class Aufwandskonto extends Konto
{
    public Aufwandskonto(String name)
    {
	super(name);
	this.setType(true, false, false);
    }

    public Aufwandskonto(String name, double kontostand)
    {
	super(name, kontostand);
	this.setType(true, false, false);
    }
}
