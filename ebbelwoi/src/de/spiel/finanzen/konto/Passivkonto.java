package de.spiel.finanzen.konto;

public class Passivkonto extends Konto
{
    public Passivkonto(String name)
    {
	super(name);
    }
    
    public Passivkonto(String name, double kontostand)
    {
	super(name, kontostand);
    }

    @Override
    public void kontoAbrechnen()
    {
	// TODO Auto-generated method stub
	
    }
}
