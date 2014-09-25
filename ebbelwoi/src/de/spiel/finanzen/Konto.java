package de.spiel.finanzen;

import java.util.ArrayList;

public class Konto
{
    private String kontoName;
    private double kontoStand;

    public static int transkationsNr = 1;

    public Konto()
    {
	this.kontoName = "";
	this.kontoStand = 0.0;
    }

    public Konto(String name)
    {
	this.kontoName = name;
	this.kontoStand = 0;
    }

    public Konto(String name, double anfangsbestand)
    {
	this.kontoName = name;
	this.kontoStand = anfangsbestand;

    }

    // GETTER
    public String getKontoName()
    {
	return kontoName;
    }

    public double getKontoStand()
    {
	return kontoStand;
    }

    // OTHER METHODS
    protected boolean einzahlen(double betrag)
    {
	if (betrag > 0) {
	    this.kontoStand += betrag;
	    return true;
	} else {
	    return false;
	}

    }

    protected boolean auszahlen(double betrag)
    {
	if (betrag > 0) {
	    double div = kontoStand - betrag;
	    if (div >= 0) {
		this.kontoStand -= betrag;
		return true;
	    } else {
		if (div < 0) {
		    this.kontoStand -= Math.abs(div);
		    return true;
		} else {
		    return false;
		}
	    }
	} else {
	    return false;
	}
    }

    @SuppressWarnings("unused")
    protected void korrektur(double korregierterStand)
    {
	this.kontoStand = korregierterStand;
    }

    @Override
    public String toString()
    {
	return "Konto [kontoName="+kontoName+", kontoStand="+kontoStand+"]";
    }

}
