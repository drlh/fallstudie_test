package de.spiel.umwelt;

public class Absatz
{
    private double preis;
    private double menge;
    
    private int lagerpos = Integer.MAX_VALUE;

    public Absatz(double menge, double preis)
    {
	this.menge = menge;
	this.preis = preis;
    }

    public Absatz(Angebot angebot)
    {
	this.menge = angebot.getMenge();
	this.preis = angebot.getPreis();
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

    public int getLagerpos()
    {
        return lagerpos;
    }

    public void setLagerpos(int lagerpos)
    {
        this.lagerpos = lagerpos;
    }
    
    
}
