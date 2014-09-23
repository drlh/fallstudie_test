package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.mitarbeiter.*;

public class Einkauf extends Abteilung
{
    public Einkauf()
    {
	super();
	this.abteilungName = "Einkauf";
	this.mitarbeiter = new ArrayList<Mitarbeiter>();
    }

    @Override
    public void addMitarbeiter()
    {
	this.mitarbeiter.add(new Vertrieb());
    }

    @Override
    public void entlasseMitarbeiter(String name)
    {
	
    }

    


}
