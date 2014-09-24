package de.spiel.unternehmen.abteilung;

import java.util.ArrayList;

import de.spiel.unternehmen.mitarbeiter.Mitarbeiter;
import de.spiel.unternehmen.mitarbeiter.Vertrieb;

public class Marketing extends Abteilung
{
    public Marketing()
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
}
