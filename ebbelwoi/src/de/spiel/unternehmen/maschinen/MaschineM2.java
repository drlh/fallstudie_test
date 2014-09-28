package de.spiel.unternehmen.maschinen;

import de.spiel.basic.stufen.MaschinenStufen;
import de.spiel.unternehmen.mitarbeiter.Produktionsmitarbeiter;

public class MaschineM2 extends Maschine
{
    public MaschineM2()
    {
	super();
	this.anschaffungskosten = 65000.0;
	this.abschreibungsdauer = 5;
	calcAbschreibung();
	calcFixkosten();
	
	this.kapazitaet = 500000.0;
	this.auswurf = 0.2;
	this.maschinenfuehrer = null;
	
	this.stufe = new MaschinenStufen();
    }
    
    public MaschineM2(Produktionsmitarbeiter mitarbeiter)
    {
	super();
	this.anschaffungskosten = 65000.0;
	this.abschreibungsdauer = 5;
	calcAbschreibung();
	calcFixkosten();
	
	this.kapazitaet = 500000.0;
	this.auswurf = 0.2;
	this.maschinenfuehrer = null;
	
	this.stufe = new MaschinenStufen();
    }
}
