package de.spiel.unternehmen;

import de.spiel.unternehmen.abteilung.*;
import de.spiel.unternehmen.abteilung.produktion.*;

public class Unternehmen
{
    private Abteilung[] abteilung = new Abteilung[5];  
    private static Lager lager;
    
    public Unternehmen()
    {
    	initialisieren();
    }
    private void initialisieren(){
    	
    	Abteilung.setUnternehmen(this);
    	
    	lager = new Lager();
    	
    	abteilung[0] = new Einkauf();
    	abteilung[1] = new Verkauf();
    	abteilung[2] = new Marketing();
    	abteilung[3] = new Produktion();
    	abteilung[4] = new Finanzen();
    }

    public Einkauf getEinkauf()
    {
        return (Einkauf)abteilung[0];
    }
    public Verkauf getVerkauf()
    {
    	return (Verkauf)abteilung[1];
    }
    public Marketing getMarketing()
    {
    	return (Marketing)abteilung[2];
    }
    public Produktion getProduktion()
    {
    	return (Produktion)abteilung[3];
    }    
    public Finanzen getFinanzen()
    {
	return (Finanzen)abteilung[4];
    }
    public Lager getLager()
    {
	return lager;
    }
    
    public Abteilung getAbteilung(int nr){
    	if(nr>4)
    		return null;
    	return abteilung[nr];
    }


}
