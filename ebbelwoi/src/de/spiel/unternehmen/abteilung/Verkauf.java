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


}
