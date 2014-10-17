package de.spiel.finanzen.konto;

public class Aktivkonto extends Konto
{
    public Aktivkonto(String name)
    {
	super(name);
    }
    
    public Aktivkonto(String name, double kontostand)
    {
	super(name, kontostand);
    }

    @Override
    public void kontoAbrechnen()
    {
	// TODO Auto-generated method stub
	
    }
}
