package de.spiel.umwelt;

public class Absatz
{
    private double preis;
    private double menge;

    public Absatz(double menge, double preis)
    {
	this.menge = menge;
	this.preis = preis;
    }

    public double getPreis()
    {
        return preis;
    }

    public double getMenge()
    {
        return menge;
    }
    
    
    public double getUmsatz()
    {
	return this.preis * ((double) menge);
    }
}
