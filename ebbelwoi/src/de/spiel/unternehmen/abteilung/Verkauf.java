package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;

public class Verkauf extends Abteilung
{

    public Verkauf()
    {
	super();
	this.abteilungName = "Verkauf";
	this.mitarbeiter = new ArrayList<Mitarbeiter>();
    }
    
    @Override
    public void addMitarbeiter()
    {
	// TODO Auto-generated method stub
	
    }
    
    public void getGesuche(boolean kneipe) {
		//es fehlt eine Art getSpiel, damit man auf die Umwelt referenzieren kann
		if (kneipe) {
			//getSpiel().getUmwelt().getAMarkt().getKneipenAngebote();
		} else {
			//getSpiel().getUmwelt().getAMarkt().getSupermarktAngebote();
		}		
	}

}
