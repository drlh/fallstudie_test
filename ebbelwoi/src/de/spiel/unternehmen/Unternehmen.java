package de.spiel.unternehmen;

import de.spiel.unternehmen.abteilung.*;
import de.spiel.unternehmen.abteilung.produktion.*;

public class Unternehmen
{
    private Einkauf einkauf;
    private Verkauf verkauf;
    private Marketing marketing;
    private Produktion produktion;
    private Lager lager;
    
    public Unternehmen()
    {
	this.einkauf = new Einkauf();
	this.verkauf = new Verkauf();
	this.marketing = new Marketing();
	this.produktion = new Produktion();
	this.lager = new Lager();
    }

    public Einkauf getEinkauf()
    {
        return einkauf;
    }
    public Verkauf getVerkauf()
    {
        return verkauf;
    }
    public Marketing getMarketing()
    {
        return marketing;
    }
    public Produktion getProduktion()
    {
        return produktion;
    }
    public Lager getLager()
    {
        return lager;
    }
    
    
}
