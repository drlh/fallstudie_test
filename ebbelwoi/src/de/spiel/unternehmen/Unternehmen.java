package de.spiel.unternehmen;

import de.spiel.umwelt.Umwelt;
import de.spiel.unternehmen.abteilung.*;
import de.spiel.unternehmen.abteilung.produktion.*;

public class Unternehmen
{
    private static Umwelt umwelt;
    
    private Abteilung[] abteilung;
    private Lager lager;
    
    public String spielerName = "";

    public Unternehmen()
    {
	initialisieren();
    }

    private void initialisieren()
    {
	umwelt = new Umwelt();

	abteilung = new Abteilung[5];

	lager = new Lager();

	abteilung[0] = new Einkauf();
	abteilung[1] = new Verkauf();
	abteilung[2] = new Marketing();
	abteilung[3] = new Produktion();
	abteilung[4] = new Finanzen();
	
	for (int i = 0; i < abteilung.length; i++) {
	    abteilung[i].setUnternehmen(this);
	}
	
	getFinanzen().bucheStartguthaben();
    }

    // GETTER
    public Einkauf getEinkauf()
    {
	return (Einkauf) abteilung[0];
    }

    public Verkauf getVerkauf()
    {
	return (Verkauf) abteilung[1];
    }

    public Marketing getMarketing()
    {
	return (Marketing) abteilung[2];
    }

    public Produktion getProduktion()
    {
	return (Produktion) abteilung[3];
    }

    public Finanzen getFinanzen()
    {
	return (Finanzen) abteilung[4];
    }

    public Lager getLager()
    {
	return lager;
    }

    public Abteilung getAbteilung(int nr)
    {
	if (nr > 4) return null;
	return abteilung[nr];
    }

    public Umwelt getUmwelt()
    {
	return umwelt;
    }
    
    public String getSpielerName()
    {
	return spielerName;
    }
    
    public void setSpielerName(String spielerName)
    {
	this.spielerName = spielerName;
    }
}
