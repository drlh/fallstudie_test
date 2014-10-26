package de.spiel.umwelt.beschaffung;

import de.spiel.basic.Produkt;

public class Nachfrage
{
    private double menge;

    public Nachfrage(double menge)
    {
	this.menge = menge;
    }

    public double getMenge()
    {
	return menge;
    }
}
