package de.spiel.finanzen.konto;

public class Aufwandskonto extends Konto
{
    public Aufwandskonto(String name)
    {
	super(name);
    }

    public Aufwandskonto(String name, double kontostand)
    {
	super(name, kontostand);
    }

    @Override
    public void kontoAbrechnen()
    {
	// TODO Auto-generated method stub
	
    }
}
