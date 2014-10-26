package de.spiel.umwelt;

import de.spiel.basic.Produkt;

public class Angebot
{
    private double preis;
    private double menge;

    private int lagerpos = Integer.MAX_VALUE;

    public Angebot(double preis, double menge)
    {
	this.menge = menge;
	this.preis = preis;
    }
    
    public Angebot(double preis, double menge, int lagerpos)
    {
	this.menge = menge;
	this.preis = preis;
	this.lagerpos = lagerpos;
    }

    public Angebot(Produkt p, double preis)
    {
	this.menge = p.getMenge();
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

    public int getLagerpos()
    {
        return lagerpos;
    }

    public void setLagerpos(int lagerpos)
    {
        this.lagerpos = lagerpos;
    }
    
    

}
