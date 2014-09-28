package de.spiel.unternehmen.abteilung.produktion;

import de.spiel.basic.Rohstoff;
import de.spiel.unternehmen.maschinen.Maschine;

public class Produktionsauftrag
{
    private Maschine produzierendeMaschine;
    private Rohstoff verwendeterRohsoff;
    
    public Produktionsauftrag(Maschine maschine, Rohstoff rohstoff)
    {
	this.produzierendeMaschine = maschine;
	this.verwendeterRohsoff = rohstoff;
    }

    //GETTER
    public Maschine getProduzierendeMaschine()
    {
        return produzierendeMaschine;
    }
    
    public Rohstoff getVerwendeterRohsoff()
    {
        return verwendeterRohsoff;
    }
    
    
    
}
