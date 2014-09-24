package de.spiel.unternehmen.abteilung.produktion;

import java.util.ArrayList;

import de.spiel.unternehmen.abteilung.Abteilung;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.mitarbeiter.*;

public class Produktion extends Abteilung
{
    private ArrayList<Maschine> maschinenpark;
    
    public Produktion()
    {
	super();
	this.abteilungName = "Produktion";
	this.mitarbeiter = new ArrayList<Mitarbeiter>();
	this.maschinenpark = new ArrayList<Maschine>();
    }

    @Override
    public void addMitarbeiter(){}
    
    public void addAzubi()
    {
	this.mitarbeiter.add(new Azubi());
    }
    
    public void addGeselle()
    {
	this.mitarbeiter.add(new Geselle());
    }
    
    public void addMeister()
    {
	this.mitarbeiter.add(new Meister());
    }
}
