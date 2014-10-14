package de.spiel.unternehmen;

import de.spiel.finanzenALT.Konto;
import de.spiel.unternehmen.abteilung.*;
import de.spiel.unternehmen.abteilung.produktion.*;

public class Unternehmen
{
    private Abteilung[] abteilung = new Abteilung[4];  
    private static Konto konto;
    private static Lager lager;
    
    public Unternehmen()
    {
    	initialisieren();
    }
    private void initialisieren(){
	
    	Abteilung.setUnternehmen(this);
    	
    	konto = new Konto("Kasse", 100000);
    	lager = new Lager();
    	
    	abteilung[0] = new Einkauf();
    	abteilung[1] = new Verkauf();
    	abteilung[2] = new Marketing();
    	abteilung[3] = new Produktion();
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
    
    public Abteilung getAbteilung(int nr){
    	if(nr>3)
    		return null;
    	return abteilung[nr];
    }

	public Konto getKonto() {
		return konto;
	}
	public Lager getLager() {
		return lager;
	}
}
