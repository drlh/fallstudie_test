package de.spiel.finanzen.konto;

public class Ertragskonto extends Konto
{
    public Ertragskonto(String name)
    {
	super(name);
    }

    public Ertragskonto(String name, double kontostand)
    {
	super(name, kontostand);
    }

    @Override
    public void kontoAbrechnen()
    {
	// TODO Auto-generated method stub
	
    }
}
