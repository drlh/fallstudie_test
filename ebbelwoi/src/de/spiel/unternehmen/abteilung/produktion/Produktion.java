package de.spiel.unternehmen.abteilung.produktion;

import java.util.ArrayList;

import org.junit.Ignore;

import de.spiel.basic.Produkt;
import de.spiel.basic.Rohstoff;
import de.spiel.unternehmen.abteilung.Abteilung;
import de.spiel.unternehmen.maschinen.Maschine;
import de.spiel.unternehmen.mitarbeiter.*;

public class Produktion extends Abteilung
{
    private ArrayList<Maschine> maschinenpark;
    private ArrayList<Produktionsauftrag> auftraege;
    
    public Produktion()
    {
	super();
	this.abteilungName = "Produktion";
	this.mitarbeiter = new ArrayList<Mitarbeiter>();
	this.maschinenpark = new ArrayList<Maschine>();
	this.auftraege = new ArrayList<Produktionsauftrag>();
    }

    @Override
    public void addMitarbeiter(){}
   
    //Mitarbeiter    
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
    
    //Produktion
    public void addAuftrag(Maschine maschine, Rohstoff rohstoff)
    {
	this.auftraege.add(new Produktionsauftrag(maschine, rohstoff));
    }
    
    /**
     * Grundlage: 1kg Äpfel - 0,33l Apfelwein (Quelle: 
     */
    public void produzieren()
    {
	double ausbringungsmenge = 0.0;
	
    	for (int i = 0; i < auftraege.size(); i++) 
    	{
	    double menge = auftraege.get(i).getVerwendeterRohsoff().getMenge();
	    double produktivitaetMa = (double) auftraege.get(i).getProduzierendeMaschine().getMaschinenfuehrer().getBonus()/100;
	    double maschinenstufe = (double) auftraege.get(i).getProduzierendeMaschine().getStufe().getBonus()/100;
	    double auswurf = auftraege.get(i).getProduzierendeMaschine().getAuswurf();
	    
	    ausbringungsmenge = (menge * (1 - (auswurf - maschinenstufe - ausbringungsmenge - produktivitaetMa)))*(1/3);
	    
	}
    	
    	this.getLager().addProdukt(new Produkt(ausbringungsmenge));
    }
}
